package com.springBootNoJwt.apis;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springBootNoJwt.dtos.CreateBuildingDto;
import com.springBootNoJwt.dtos.buildings.FindBuildingsResponseDto;
import com.springBootNoJwt.exceptions.InvalidDataException;
import com.springBootNoJwt.services.BuildingService;

@RestController()
@RequestMapping("/v1/building")
public class BuildingApi {
	
	@Autowired
	private BuildingService buildingService;

	@PostMapping
	public Object createBuilding(@RequestBody CreateBuildingDto body) {
		if (body.getName() == null || body.getName().trim().isEmpty()) {
			throw new InvalidDataException("Building name should not empty");
		}

		if (body.getPrice() == null) {
			throw new InvalidDataException("Building price should not empty");
		}

		return body;
	}

	@GetMapping
	public List<FindBuildingsResponseDto> findBuildings(@RequestParam Map<String, String> query) {
		System.out.println(this.buildingService);
		
		List<FindBuildingsResponseDto> buildings = this.buildingService.find(query);
		return buildings;
	}

	@GetMapping("/{id}")
	public String findBuildingById(@PathVariable String id) {
		System.out.println(id);
		return "ok";
	}
}