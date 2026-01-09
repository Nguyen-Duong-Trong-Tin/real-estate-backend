package com.springBootNoJwt.services;

import java.util.List;
import java.util.Map;

import com.springBootNoJwt.dtos.buildings.BuildingResponseDto;
import com.springBootNoJwt.dtos.buildings.create.BuildingCreateDto;
import com.springBootNoJwt.dtos.buildings.find.BuildingFindResponseDto;
import com.springBootNoJwt.dtos.buildings.update.BuildingUpdateDto;

public interface BuildingService {
	BuildingResponseDto create(BuildingCreateDto body);

	BuildingResponseDto update(Long id, BuildingUpdateDto body);

	void delete(Long id);

	List<BuildingFindResponseDto> find(Map<String, String> query);
}
