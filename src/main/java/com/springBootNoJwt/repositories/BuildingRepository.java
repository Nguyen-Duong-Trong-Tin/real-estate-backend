package com.springBootNoJwt.repositories;

import java.util.List;

import com.springBootNoJwt.builders.BuildingBuilder;
import com.springBootNoJwt.repositories.entity.BuildingEntity;

public interface BuildingRepository {
	List<BuildingEntity> find(BuildingBuilder buildingBuilder);
}
