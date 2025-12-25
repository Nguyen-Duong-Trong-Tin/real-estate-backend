package com.springBootNoJwt.services;

import java.util.List;
import java.util.Map;

import com.springBootNoJwt.dtos.buildings.BuildingResponseDto;

public interface BuildingService {
	List<BuildingResponseDto> find(Map<String, String> query);
}
