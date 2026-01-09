package com.springBootNoJwt.repositories;

import java.util.List;

import com.springBootNoJwt.builders.BuildingBuilder;
import com.springBootNoJwt.repositories.entity.BuildingEntity;

public interface BuildingRepository {
	BuildingEntity create(BuildingEntity buildingEntity);
	
	BuildingEntity update(Long id, BuildingEntity buildingEntity);
	
	void delete(Long id);
	
	List<BuildingEntity> find(BuildingBuilder buildingBuilder);

	BuildingEntity findById(Long id);
}
