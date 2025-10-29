package com.springBootNoJwt.repositories.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.springBootNoJwt.repositories.BuildingRepository;
import com.springBootNoJwt.repositories.entity.BuildingEntity;

@Repository
public class BuildingRepositoryImpl implements BuildingRepository {

	private String jdbcUrl = "jdbc:mysql://localhost:3306/real_estate?useSSL=false&serverTimezone=UTC";
	private String jdbcUser = "root";
	private String jdbcPassword = "";

	@Override
	public List<BuildingEntity> find(Map<String, String> query) {
		String name = query.get("name");
		String districtId = query.get("districtId");
		String rentType = query.get("rentType");
		
		String sql = "SELECT * FROM buildings WHERE 1";
		if (name != null) {
			sql += String.format(" AND name LIKE '%%%s%%'", name);
		}
		if (districtId != null) {
			sql += String.format(" AND districtId = '%s'", districtId);
		}
		if (rentType != null) {
			String rentTypes[] = rentType.split(",");
			int rentTypesLength = rentTypes.length;
			
			rentType = "";
			for (int index = 0; index < rentTypesLength; index++) {
				rentType += String.format("'%s'", rentTypes[index]);
			
				if (index < rentTypes.length - 1) {
					rentType += ",";
				}
			}
			
			sql += String.format(" AND rentTypeCode IN (%s)", rentType);
		}
		
		List<BuildingEntity> buildings = new ArrayList<BuildingEntity>();

		try (Connection conn = DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPassword);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);) {
			ResultSetMetaData meta = rs.getMetaData();

			while (rs.next()) {
				BuildingEntity building = new BuildingEntity(rs.getString("houseId"), rs.getString("name"),
						rs.getString("ward"), rs.getString("street"), rs.getString("structure"),
						rs.getInt("basementQuantity"), rs.getInt("floorArea"), rs.getString("direction"),
						rs.getString("class"), rs.getString("rentalArea"), rs.getString("rentalPrice"),
						rs.getString("priceDescription"), rs.getInt("serviceFee"), rs.getInt("carFees"),
						rs.getInt("motorcycleFee"), rs.getInt("overtimeFee"), rs.getInt("electricityBill"),
						rs.getInt("deposit"), rs.getInt("pay"), rs.getInt("rentalPeriod"), rs.getInt("decoratorTime"),
						rs.getString("managerName"), rs.getString("managerPhone"), rs.getInt("brokerageFees"),
						rs.getString("buildingType"), rs.getString("note"));

				buildings.add(building);
			}
		} catch (SQLException error) {
			error.printStackTrace();
			throw new RuntimeException("Database error: " + error.getMessage());
		}

		return buildings;
	}
}
