package com.springBootNoJwt.repositories;

import java.util.List;
import java.util.Map;

import com.springBootNoJwt.repositories.entity.BuildingEntity;

public interface BuildingRepository {
	List<BuildingEntity> find(Map<String, String> query);
}
