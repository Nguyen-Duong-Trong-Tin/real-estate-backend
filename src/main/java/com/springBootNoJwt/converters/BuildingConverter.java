package com.springBootNoJwt.converters;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springBootNoJwt.dtos.buildings.BuildingResponseDto;
import com.springBootNoJwt.repositories.entity.BuildingEntity;
import com.springBootNoJwt.repositories.entity.DistrictEntity;
import com.springBootNoJwt.repositories.entity.RentTypeEntity;
import com.springBootNoJwt.utils.StringUtil;

@Component
public class BuildingConverter {
  @Autowired
  private ModelMapper modelMapper;

  public BuildingEntity toBuildingEntity(ResultSet rs) throws SQLException {
    BuildingEntity building = new BuildingEntity(rs.getString("id"), rs.getString("name"),
        rs.getString("ward"), rs.getString("street"), rs.getString("districtId"),
        rs.getString("structure"), rs.getInt("basementQuantity"), rs.getInt("floorArea"),
        rs.getString("direction"), rs.getString("class"),
        rs.getInt("rentalPrice"), rs.getString("priceDescription"), rs.getInt("serviceFee"),
        rs.getInt("carFees"), rs.getInt("motorcycleFee"), rs.getInt("overtimeFee"),
        rs.getInt("electricityBill"), rs.getInt("deposit"), rs.getInt("pay"), rs.getInt("rentalPeriod"),
        rs.getInt("decoratorTime"), rs.getString("managerName"), rs.getString("managerPhone"),
        rs.getInt("brokerageFees"), rs.getString("buildingType"), rs.getString("note"),
        rs.getString("rentTypeCode"));

    DistrictEntity district = new DistrictEntity(
        rs.getString("districtId"),
        rs.getString("district_name"),
        rs.getString("district_description"));
    building.setDistrict(district);

    RentTypeEntity rentType = new RentTypeEntity(
        rs.getString("rent_type_id"),
        rs.getString("rentTypeCode"),
        rs.getString("rent_type_name"));
    building.setRentType(rentType);

    List<Integer> rentAreas = new ArrayList<Integer>();
    String rentAreasString = rs.getString("rent_areas");
    if (!StringUtil.isNullOrEmpty(rentAreasString)) {
      String[] rentAreasArray = rentAreasString.split(",");
      for (String rentAreaString : rentAreasArray) {
        int rentArea = Integer.parseInt(rentAreaString);
        rentAreas.add(rentArea);
      }
    }

    // System.out.println(rentAreas.stream()
    // .map(Object::toString)
    // .collect(Collectors.joining(", ")));
    building.setRentAreas(rentAreas);

    return building;
  }

  public BuildingResponseDto toBuildingResponseDto(BuildingEntity buildingEntity) {
    return modelMapper.map(buildingEntity, BuildingResponseDto.class);
  }
}
