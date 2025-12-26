package com.springBootNoJwt.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springBootNoJwt.builders.BuildingBuilder;
import com.springBootNoJwt.converters.BuildingConverter;
import com.springBootNoJwt.dtos.buildings.BuildingResponseDto;
import com.springBootNoJwt.repositories.BuildingRepository;
import com.springBootNoJwt.repositories.entity.BuildingEntity;
import com.springBootNoJwt.services.BuildingService;

@Service
public class BuildingServiceImpl implements BuildingService {

	@Autowired
	private BuildingRepository buildingRepository;

	@Autowired
	private BuildingConverter buildingConverter;

	@Override
	public List<BuildingResponseDto> find(Map<String, String> query) {
		BuildingBuilder buildingBuilder = buildingConverter.toBuildingBuilder(query);

		List<BuildingEntity> buildingEntities = buildingRepository.find(buildingBuilder);
		List<BuildingResponseDto> buildings = new ArrayList<BuildingResponseDto>();

		for (BuildingEntity buildingEntity : buildingEntities) {
			BuildingResponseDto building = buildingConverter.toBuildingResponseDto(buildingEntity);
			buildings.add(building);
		}

		return buildings;
	}
}
