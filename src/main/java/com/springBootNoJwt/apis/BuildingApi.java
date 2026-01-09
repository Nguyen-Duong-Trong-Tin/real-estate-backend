package com.springBootNoJwt.apis;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springBootNoJwt.dtos.buildings.BuildingResponseDto;
import com.springBootNoJwt.dtos.buildings.create.BuildingCreateDto;
import com.springBootNoJwt.dtos.buildings.find.BuildingFindResponseDto;
import com.springBootNoJwt.dtos.buildings.update.BuildingUpdateDto;
import com.springBootNoJwt.services.BuildingService;

@RestController()
@RequestMapping("/v1/building")
public class BuildingApi {

	@Autowired
	private BuildingService buildingService;

	@PostMapping
	public BuildingResponseDto create(@RequestBody BuildingCreateDto body) {
		return this.buildingService.create(body);
	}

	@PatchMapping("/{id}")
	public BuildingResponseDto update(@PathVariable Long id, @RequestBody BuildingUpdateDto body) {
		return this.buildingService.update(id, body);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		this.buildingService.delete(id);
	}

	@GetMapping
	public List<BuildingFindResponseDto> find(@RequestParam Map<String, String> query) {
		List<BuildingFindResponseDto> buildings = this.buildingService.find(query);
		return buildings;
	}

	@GetMapping("/{id}")
	public String findById(@PathVariable String id) {
		System.out.println(id);
		return "ok";
	}
}