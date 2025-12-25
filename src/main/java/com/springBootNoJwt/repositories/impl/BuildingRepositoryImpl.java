package com.springBootNoJwt.repositories.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springBootNoJwt.converters.BuildingConverter;
import com.springBootNoJwt.repositories.BuildingRepository;
import com.springBootNoJwt.repositories.entity.BuildingEntity;
import com.springBootNoJwt.utils.JdbcUtil;
import com.springBootNoJwt.utils.StringUtil;

@Repository
public class BuildingRepositoryImpl implements BuildingRepository {
	@Autowired 
	private BuildingConverter buildingConverter;

	private void findBuiltSelect(StringBuilder sql) {
		sql.append(
				"SELECT buildings.*, rent_types.id AS rent_type_id, rent_types.name AS rent_type_name, districts.name AS district_name, districts.description AS district_description, GROUP_CONCAT(rent_areas.value) AS rent_areas FROM buildings");
	}

	private void findBuiltWhere(StringBuilder sql, Map<String, String> query) {
		String name = query.get("name");
		String floorAreaString = query.get("floorArea");
		String districtId = query.get("districtId");
		String ward = query.get("ward");
		String street = query.get("street");
		String basementQuantityString = query.get("basementQuantity");
		String direction = query.get("direction");
		String hang = query.get("class");
		String rentalPriceFromString = query.get("rentalPriceFrom");
		String rentalPriceToString = query.get("rentalPriceTo");
		String managerName = query.get("managerName");
		String managerPhone = query.get("managerPhone");
		String employeeId = query.get("employeeId");
		String rentType = query.get("rentType");
		String rentAreaFromString = query.get("rentAreaFrom");
		String rentAreaToString = query.get("rentAreaTo");

		sql.append(" WHERE 1");

		if (!StringUtil.isNullOrEmpty(name)) {
			sql.append(" AND name LIKE '%").append(name).append("%'");
		}

		if (!StringUtil.isNullOrEmpty(floorAreaString)) {
			try {
				int floorArea = Integer.parseInt(floorAreaString);
				sql.append(" AND floorArea = ").append(floorArea);
			} catch (NumberFormatException e) {
			}
		}

		if (!StringUtil.isNullOrEmpty(districtId)) {
			sql.append(" AND districtId = ").append(districtId);
		}

		if (!StringUtil.isNullOrEmpty(ward)) {
			sql.append(" AND ward LIKE '%").append(ward).append("%'");
		}

		if (!StringUtil.isNullOrEmpty(street)) {
			sql.append(" AND street LIKE '%").append(street).append("%'");
		}

		if (!StringUtil.isNullOrEmpty(basementQuantityString)) {
			try {
				int basementQuantity = Integer.parseInt(basementQuantityString);
				sql.append(" AND basementQuantity = ").append(basementQuantity);
			} catch (NumberFormatException e) {
			}
		}

		if (!StringUtil.isNullOrEmpty(direction)) {
			sql.append(" AND direction = ").append(direction);
		}

		if (!StringUtil.isNullOrEmpty(hang)) {
			sql.append(" AND class = ").append(hang);
		}

		if (!StringUtil.isNullOrEmpty(rentalPriceFromString)) {
			try {
				int rentalPriceFrom = Integer.parseInt(rentalPriceFromString);
				sql.append(" AND rentalPrice >= ").append(rentalPriceFrom);
			} catch (NumberFormatException e) {
			}
		}

		if (!StringUtil.isNullOrEmpty(rentalPriceToString)) {
			try {
				int rentalPriceTo = Integer.parseInt(rentalPriceToString);
				sql.append(" AND rentalPrice <= ").append(rentalPriceTo);
			} catch (NumberFormatException e) {
			}
		}

		if (!StringUtil.isNullOrEmpty(managerName)) {
			sql.append(" AND managerName LIKE '%").append(managerName).append("%'");
		}

		if (!StringUtil.isNullOrEmpty(managerPhone)) {
			sql.append(" AND managerPhone LIKE '%").append(managerPhone).append("%'");
		}

		if (!StringUtil.isNullOrEmpty(employeeId)) {
			sql.append(" AND employeeId = ").append(employeeId);
		}

		if (!StringUtil.isNullOrEmpty(rentType)) {
			String rentTypes[] = rentType.split(",");
			int rentTypesLength = rentTypes.length;

			rentType = "";
			for (int index = 0; index < rentTypesLength; index++) {
				rentType += String.format("'%s'", rentTypes[index]);

				if (index < rentTypes.length - 1) {
					rentType += ",";
				}
			}

			sql.append(" AND rentTypeCode IN (").append(rentType).append(")");
		}

		if (!StringUtil.isNullOrEmpty(rentAreaFromString)) {
			try {
				int rentAreaFrom = Integer.parseInt(rentAreaFromString);
				sql.append(" AND rent_areas.value >= ").append(rentAreaFrom);
			} catch (NumberFormatException e) {
			}
		}

		if (!StringUtil.isNullOrEmpty(rentAreaToString)) {
			try {
				int rentAreaTo = Integer.parseInt(rentAreaToString);
				sql.append(" AND rent_areas.value <= ").append(rentAreaTo);
			} catch (NumberFormatException e) {
			}
		}
	}

	private void findBuiltJoin(StringBuilder sql) {
		sql.append(" INNER JOIN rent_types ON buildings.rentTypeCode = rent_types.code");
		sql.append(" INNER JOIN districts ON buildings.districtId = districts.id");
		sql.append(" LEFT JOIN rent_areas ON buildings.id = rent_areas.building_id");
	}

	private void findBuiltGroupBy(StringBuilder sql) {
		sql.append(" GROUP BY buildings.id");
	}

	@Override
	public List<BuildingEntity> find(Map<String, String> query) {
		StringBuilder sql = new StringBuilder("");

		findBuiltSelect(sql);
		findBuiltJoin(sql);
		findBuiltWhere(sql, query);
		findBuiltGroupBy(sql);

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
