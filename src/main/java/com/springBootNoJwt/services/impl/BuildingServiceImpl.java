package com.springBootNoJwt.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springBootNoJwt.dtos.buildings.FindBuildingsResponseDto;
import com.springBootNoJwt.repositories.BuildingRepository;
import com.springBootNoJwt.repositories.entity.BuildingEntity;
import com.springBootNoJwt.services.BuildingService;

@Service
public class BuildingServiceImpl implements BuildingService {
	
	@Autowired
	private BuildingRepository buildingRepository;

	@Override
	public List<FindBuildingsResponseDto> find(Map<String, String> query) {
		List<BuildingEntity> buildingEntities = buildingRepository.find(query);
		
		List<FindBuildingsResponseDto> buildings = new ArrayList<FindBuildingsResponseDto>();
		for (BuildingEntity buildingEntity: buildingEntities) {
			String houseId = buildingEntity.getHouseId();
			String name = buildingEntity.getName();
			String ward = buildingEntity.getWard();
			String street = buildingEntity.getStreet();
			
			FindBuildingsResponseDto building = new FindBuildingsResponseDto(houseId, name, ward, street);
			buildings.add(building);
		}
		
		return buildings;
	}
}
