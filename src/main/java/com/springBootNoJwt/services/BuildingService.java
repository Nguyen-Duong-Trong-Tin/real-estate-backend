package com.springBootNoJwt.services;

import java.util.List;
import java.util.Map;

import com.springBootNoJwt.dtos.buildings.FindBuildingsResponseDto;

public interface BuildingService {
	List<FindBuildingsResponseDto> find(Map<String, String> query);
}
