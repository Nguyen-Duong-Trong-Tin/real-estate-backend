package com.springBootNoJwt.repositories.impl;

import org.springframework.stereotype.Repository;

import com.springBootNoJwt.repositories.DistrictRepository;
import com.springBootNoJwt.repositories.entity.DistrictEntity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class DistrictRepositoryImpl implements DistrictRepository {
  @PersistenceContext
  private EntityManager entityManager;

  @Override
  public DistrictEntity findById(Long id) {
    return this.entityManager.find(DistrictEntity.class, id);
  }
}
