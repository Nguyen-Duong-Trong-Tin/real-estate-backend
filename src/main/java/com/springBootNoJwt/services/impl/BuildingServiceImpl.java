package com.springBootNoJwt.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springBootNoJwt.builders.BuildingBuilder;
import com.springBootNoJwt.converters.BuildingConverter;
import com.springBootNoJwt.dtos.buildings.BuildingResponseDto;
import com.springBootNoJwt.dtos.buildings.create.BuildingCreateDto;
import com.springBootNoJwt.dtos.buildings.find.BuildingFindResponseDto;
import com.springBootNoJwt.dtos.buildings.update.BuildingUpdateDto;
import com.springBootNoJwt.repositories.BuildingRepository;
import com.springBootNoJwt.repositories.DistrictRepository;
import com.springBootNoJwt.repositories.RentTypeRepository;
import com.springBootNoJwt.repositories.entity.BuildingEntity;
import com.springBootNoJwt.repositories.entity.DistrictEntity;
import com.springBootNoJwt.repositories.entity.RentTypeEntity;
import com.springBootNoJwt.services.BuildingService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class BuildingServiceImpl implements BuildingService {

	@Autowired
	private BuildingRepository buildingRepository;

	@Autowired
	private DistrictRepository districtRepository;

	@Autowired
	private RentTypeRepository rentTypeRepository;

	@Autowired
	private BuildingConverter buildingConverter;

	@Override
	public BuildingResponseDto create(BuildingCreateDto body) {
		BuildingEntity buildingEntity = this.buildingConverter.toBuidlingEntity(body);

		DistrictEntity districtEntity = this.districtRepository.findById(body.getDistrictId());
		if (districtEntity == null) {
			throw new EntityNotFoundException("District not found");
		}
		buildingEntity.setDistrict(districtEntity);

		RentTypeEntity rentTypeEntity = this.rentTypeRepository.findById(body.getRentTypeId());
		if (rentTypeEntity == null) {
			throw new EntityNotFoundException("Rent Type not found");
		}
		buildingEntity.setRentType(rentTypeEntity);

		BuildingEntity newBuildingEntity = this.buildingRepository.create(buildingEntity);

		BuildingResponseDto buildingResponse = this.buildingConverter
				.toBuildingResponseDto(newBuildingEntity);
		return buildingResponse;
	}

	@Override
	public BuildingResponseDto update(Long id, BuildingUpdateDto body) {
		BuildingEntity buildingEntity = this.buildingRepository.findById(id);
		if (buildingEntity == null) {
			throw new EntityNotFoundException("Building not found");
		}

		if (body.getDistrictId() != null) {
			DistrictEntity districtEntity = this.districtRepository.findById(body.getDistrictId());
			if (districtEntity == null) {
				throw new EntityNotFoundException("District not found");
			}

			buildingEntity.setDistrict(districtEntity);
		}

		if (body.getRentTypeId() != null) {
			RentTypeEntity rentTypeEntity = this.rentTypeRepository.findById(body.getRentTypeId());
			if (rentTypeEntity == null) {
				throw new EntityNotFoundException("Rent Type not found");
			}

			buildingEntity.setRentType(rentTypeEntity);
		}

		this.buildingConverter.copyToBuidlingEntity(body, buildingEntity);

		BuildingEntity newBuildingEntity = this.buildingRepository.update(id, buildingEntity);
		BuildingResponseDto buildingResponse = this.buildingConverter
				.toBuildingResponseDto(newBuildingEntity);
		return buildingResponse;
	}

	@Override
	public void delete(Long id) {
		this.buildingRepository.delete(id);
	}

	@Override
	public List<BuildingFindResponseDto> find(Map<String, String> query) {
		BuildingBuilder buildingBuilder = this.buildingConverter.toBuildingBuilder(query);

		List<BuildingEntity> buildingEntities = this.buildingRepository.find(buildingBuilder);
		List<BuildingFindResponseDto> buildings = new ArrayList<BuildingFindResponseDto>();

		for (BuildingEntity buildingEntity : buildingEntities) {
			BuildingFindResponseDto building = this.buildingConverter.toBuildingFindResponseDto(buildingEntity);
			buildings.add(building);
		}

		return buildings;
	}
}
