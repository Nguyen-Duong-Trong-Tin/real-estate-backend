package com.springBootNoJwt.converters;

import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springBootNoJwt.builders.BuildingBuilder;
import com.springBootNoJwt.dtos.buildings.BuildingResponseDto;
import com.springBootNoJwt.dtos.buildings.create.BuildingCreateDto;
import com.springBootNoJwt.dtos.buildings.find.BuildingFindResponseDto;
import com.springBootNoJwt.dtos.buildings.update.BuildingUpdateDto;
import com.springBootNoJwt.repositories.entity.BuildingEntity;
import com.springBootNoJwt.utils.MapUtil;
import com.springBootNoJwt.utils.StringUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Component
public class BuildingConverter {
  @Autowired
  private ModelMapper modelMapper;

  @PersistenceContext
  private EntityManager entityManager;

  public BuildingBuilder toBuildingBuilder(Map<String, String> query) {
    BuildingBuilder buildingBuilder = BuildingBuilder.builder()
        .name(MapUtil.getObject(query, "name", String.class))
        .ward(MapUtil.getObject(query, "ward", String.class))
        .street(MapUtil.getObject(query, "street", String.class))
        .basementQuantity(MapUtil.getObject(query, "basementQuantity", Integer.class))
        .direction(MapUtil.getObject(query, "direction", String.class))
        .hang(MapUtil.getObject(query, "hang", String.class))
        .managerName(MapUtil.getObject(query, "managerName", String.class))
        .managerPhone(MapUtil.getObject(query, "managerPhone", String.class))
        .districtId(MapUtil.getObject(query, "districtId", Long.class))
        .employeeId(MapUtil.getObject(query, "employeeId", Long.class))
        .rentTypes(StringUtil.splitToList(
            MapUtil.getObject(query, "rentTypes", String.class),
            ",",
            String.class))
        .rentAreaFrom(MapUtil.getObject(query, "rentAreaFrom", Long.class))
        .rentAreaTo(MapUtil.getObject(query, "rentAreaTo", Long.class))
        .floorAreaFrom(MapUtil.getObject(query, "floorAreaFrom", Integer.class))
        .floorAreaTo(MapUtil.getObject(query, "floorAreaTo", Integer.class))
        .rentPriceFrom(MapUtil.getObject(query, "rentPriceFrom", Long.class))
        .rentPriceTo(MapUtil.getObject(query, "rentPriceTo", Long.class))
        .build();
    return buildingBuilder;
  }

  public BuildingFindResponseDto toBuildingFindResponseDto(BuildingEntity buildingEntity) {
    BuildingFindResponseDto buildingResponse = modelMapper.map(buildingEntity, BuildingFindResponseDto.class);
    return buildingResponse;
  }

  public BuildingEntity toBuidlingEntity(BuildingCreateDto buildingCreateDto) {
    BuildingEntity buildingEntity = modelMapper.map(buildingCreateDto, BuildingEntity.class);
    return buildingEntity;
  }

  public BuildingResponseDto toBuildingResponseDto(BuildingEntity buildingEntity) {
    BuildingResponseDto response = modelMapper.map(buildingEntity, BuildingResponseDto.class);
    return response;
  }

  public void copyToBuidlingEntity(BuildingUpdateDto buildingUpdateDto, BuildingEntity buildingEntity) {
    modelMapper.map(buildingUpdateDto, buildingEntity);
  }
}
