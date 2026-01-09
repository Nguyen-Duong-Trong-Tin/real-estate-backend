package com.springBootNoJwt.repositories.impl;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.springBootNoJwt.builders.BuildingBuilder;
import com.springBootNoJwt.repositories.BuildingRepository;
import com.springBootNoJwt.repositories.entity.BuildingEntity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
public class BuildingRepositoryImpl implements BuildingRepository {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional
	public BuildingEntity create(BuildingEntity buildingEntity) {
		this.entityManager.persist(buildingEntity);
		return buildingEntity;
	}

	@Override
	@Transactional
	public BuildingEntity update(Long id, BuildingEntity buildingEntity) {
		this.entityManager.merge(buildingEntity);
		return buildingEntity;
	}

	@Override
	@Transactional
	public void delete(Long id) {
		BuildingEntity buildingEntity = this.entityManager.find(BuildingEntity.class, id);
		if (buildingEntity == null) {
			throw new EntityNotFoundException("Building not found");
		}

		this.entityManager.remove(buildingEntity);
	}

	private void findBuiltSelect(StringBuilder sql) {
		sql.append("SELECT DISTINCT buildings.* FROM buildings");
	}

	private void findBuiltJoin(StringBuilder sql) {
		sql.append(" INNER JOIN rentTypes ON buildings.rentTypeId = rentTypes.id");
		sql.append(" INNER JOIN rentAreas ON rentAreas.buildingId = buildings.id");
	}

	private void findBuiltWhereNormal(StringBuilder sql, BuildingBuilder buildingBuilder) {
		Set<String> specialProperties = new HashSet<>(Arrays.asList(
				"hang", "districtId", "employeeId", "rentTypes", "rentAreaFrom", "rentAreaTo",
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
		String hang = buildingBuilder.getHang();
		Long districtId = buildingBuilder.getDistrictId();
		Long employeeId = buildingBuilder.getEmployeeId();
		List<String> rentTypes = buildingBuilder.getRentTypes();
		Long rentAreaFrom = buildingBuilder.getRentAreaFrom();
		Long rentAreaTo = buildingBuilder.getRentAreaTo();
		Long rentPriceFrom = buildingBuilder.getRentPriceFrom();
		Long rentPriceTo = buildingBuilder.getRentPriceTo();
		Integer floorAreaFrom = buildingBuilder.getFloorAreaFrom();
		Integer floorAreaTo = buildingBuilder.getFloorAreaTo();

		if (hang != null) {
			sql.append(" AND buildings.class LIKE '%").append(hang).append("%'");
		}

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

			sql.append(" AND rentTypes.code IN (").append(rentTypeList).append(")");
		}

		if (rentAreaFrom != null) {
			sql.append(
					" AND EXISTS (SELECT 1 FROM rentAreas WHERE rentAreas.buildingId = buildings.id AND rentAreas.value >= ")
					.append(rentAreaFrom).append(")");
		}
		if (rentAreaTo != null) {
			sql.append(
					" AND EXISTS (SELECT 1 FROM rentAreas WHERE rentAreas.buildingId = buildings.id AND rentAreas.value <= ")
					.append(rentAreaTo).append(")");
		}

		if (rentPriceFrom != null) {
			sql.append(
					" AND EXISTS (SELECT 1 FROM rentAreas WHERE rentAreas.buildingId = buildings.id AND rentAreas.price >= ")
					.append(rentPriceFrom).append(")");
		}
		if (rentPriceTo != null) {
			sql.append(
					" AND EXISTS (SELECT 1 FROM rentAreas WHERE rentAreas.buildingId = buildings.id AND rentAreas.price <= ")
					.append(rentPriceTo).append(")");
		}

		System.out.println("Floor Area From: " + floorAreaFrom);

		if (floorAreaFrom != null) {
			sql.append(" AND buildings.floorArea >= ").append(floorAreaFrom);
		}

		if (floorAreaTo != null) {
			sql.append(" AND buildings.floorArea <= ").append(floorAreaTo);
		}
	}

	@Override
	public List<BuildingEntity> find(BuildingBuilder buildingBuilder) {
		// jpql
		// StringBuilder jpql = new StringBuilder(
		// "SELECT building FROM BuildingEntity building WHERE 1=1 AND building.name
		// LIKE '%building%'");
		// TypedQuery<BuildingEntity> query = entityManager.createQuery(jpql.toString(),
		// BuildingEntity.class);

		// sql
		StringBuilder sql = new StringBuilder("");
		this.findBuiltSelect(sql);
		this.findBuiltJoin(sql);
		this.findBuiltWhereNormal(sql, buildingBuilder);
		this.findBuiltWhereSpecial(sql, buildingBuilder);

		System.out.println(sql.toString());

		Query query = entityManager.createNativeQuery(sql.toString(),
				BuildingEntity.class);

		@SuppressWarnings("unchecked")
		List<BuildingEntity> buildings = query.getResultList();

		return buildings;
	}

	@Override
	public BuildingEntity findById(Long id) {
		return this.entityManager.find(BuildingEntity.class, id);
	}
}
