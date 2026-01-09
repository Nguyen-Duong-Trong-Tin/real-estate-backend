package com.springBootNoJwt.repositories;

import com.springBootNoJwt.repositories.entity.DistrictEntity;

public interface DistrictRepository {
  DistrictEntity findById(Long id);
}
