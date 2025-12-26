package com.springBootNoJwt.repositories.impl;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springBootNoJwt.builders.BuildingBuilder;
import com.springBootNoJwt.converters.BuildingConverter;
import com.springBootNoJwt.repositories.BuildingRepository;
import com.springBootNoJwt.repositories.entity.BuildingEntity;
import com.springBootNoJwt.utils.JdbcUtil;

@Repository
public class BuildingRepositoryImpl implements BuildingRepository {
	@Autowired
	private BuildingConverter buildingConverter;

	private void findBuiltSelect(StringBuilder sql) {
		sql.append("SELECT buildings.*")
				.append(", rent_types.id AS rent_type_id")
				.append(", rent_types.name AS rent_type_name")
				.append(", districts.name AS district_name")
				.append(", districts.description AS district_description")
				.append(", GROUP_CONCAT(rent_areas.value) AS rent_areas")
				.append(" FROM buildings");
	}

	private void findBuiltJoin(StringBuilder sql) {
		sql.append(" INNER JOIN rent_types ON buildings.rentTypeCode = rent_types.code");
		sql.append(" INNER JOIN districts ON buildings.districtId = districts.id");
		sql.append(" LEFT JOIN rent_areas ON buildings.id = rent_areas.building_id");
	}

	private void findBuiltWhereNormal(StringBuilder sql, BuildingBuilder buildingBuilder) {
		Set<String> specialProperties = new HashSet<>(Arrays.asList(
				"districtId", "employeeId", "rentTypes", "rentAreaFrom", "rentAreaTo",
				"rentPriceFrom", "rentPriceTo", "floorAreaFrom", "floorAreaTo"));

		sql.append(" WHERE 1");

		try {
			for (Field field : BuildingBuilder.class.getDeclaredFields()) {
				field.setAccessible(true);
				String fieldName = field.getName();

				if (specialProperties.contains(fieldName)) {
					continue;
				}

				Object fieldValue = field.get(buildingBuilder);
				if (fieldValue == null) {
					continue;
				}

				if (field.getType() == String.class) {
					sql.append(" AND buildings.").append(fieldName)
							.append(" LIKE '%").append(fieldValue).append("%'");
				} else {
					sql.append(" AND buildings.").append(fieldName)
							.append(" = ").append(fieldValue);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void findBuiltWhereSpecial(StringBuilder sql, BuildingBuilder buildingBuilder) {
		String districtId = buildingBuilder.getDistrictId();
		String employeeId = buildingBuilder.getEmployeeId();
		List<String> rentTypes = buildingBuilder.getRentTypes();
		Integer rentAreaFrom = buildingBuilder.getRentAreaFrom();
		Integer rentAreaTo = buildingBuilder.getRentAreaTo();
		Long rentPriceFrom = buildingBuilder.getRentPriceFrom();
		Long rentPriceTo = buildingBuilder.getRentPriceTo();
		Integer floorAreaFrom = buildingBuilder.getFloorAreaFrom();
		Integer floorAreaTo = buildingBuilder.getFloorAreaTo();

		if (districtId != null) {
			sql.append(" AND buildings.districtId = ").append(districtId);
		}

		if (employeeId != null) {
			sql.append(" AND buildings.employeeId = ").append(employeeId);
		}

		if (rentTypes != null) {
			String rentTypeList = rentTypes.stream()
					.map(rentType -> "'" + rentType + "'")
					.collect(Collectors.joining(", "));
			sql.append(" AND buildings.rentTypeCode IN (").append(rentTypeList).append(")");
		}

		if (rentAreaFrom != null) {
			sql.append(
					" AND EXISTS (SELECT 1 FROM rent_areas WHERE rent_areas.building_id = buildings.id AND rent_areas.value >= ")
					.append(rentAreaFrom).append(")");
		}
		if (rentAreaTo != null) {
			sql.append(
					" AND EXISTS (SELECT 1 FROM rent_areas WHERE rent_areas.building_id = buildings.id AND rent_areas.value <= ")
					.append(rentAreaTo).append(")");
		}

		if (rentPriceFrom != null) {
			sql.append(
					" AND EXISTS (SELECT 1 FROM rent_areas WHERE rent_areas.building_id = buildings.id AND rent_areas.price >= ")
					.append(rentPriceFrom).append(")");
		}
		if (rentPriceTo != null) {
			sql.append(
					" AND EXISTS (SELECT 1 FROM rent_areas WHERE rent_areas.building_id = buildings.id AND rent_areas.price <= ")
					.append(rentPriceTo).append(")");
		}

		if (floorAreaFrom != null) {
			sql.append(" AND buildings.floorArea >= ").append(floorAreaFrom);
		}

		if (floorAreaTo != null) {
			sql.append(" AND buildings.floorArea <= ").append(floorAreaTo);
		}
	}


	private void findBuiltGroupBy(StringBuilder sql) {
		sql.append(" GROUP BY buildings.id");
	}

	@Override
	public List<BuildingEntity> find(BuildingBuilder buildingBuilder) {
		StringBuilder sql = new StringBuilder("");

		findBuiltSelect(sql);
		findBuiltJoin(sql);
		findBuiltWhereNormal(sql, buildingBuilder);
		findBuiltWhereSpecial(sql, buildingBuilder);
		findBuiltGroupBy(sql);

		System.out.println(sql.toString());

		List<BuildingEntity> buildings = new ArrayList<BuildingEntity>();

		try (Connection conn = JdbcUtil.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql.toString());) {
			while (rs.next()) {
				BuildingEntity building = buildingConverter.toBuildingEntity(rs);
				buildings.add(building);
			}
		} catch (SQLException error) {
			error.printStackTrace();
			throw new RuntimeException("Database error: " + error.getMessage());
		}

		return buildings;
	}
}
