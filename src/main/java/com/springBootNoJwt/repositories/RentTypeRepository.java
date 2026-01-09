package com.springBootNoJwt.repositories;

import com.springBootNoJwt.repositories.entity.RentTypeEntity;

public interface RentTypeRepository {
  RentTypeEntity findById(Long id);
}
