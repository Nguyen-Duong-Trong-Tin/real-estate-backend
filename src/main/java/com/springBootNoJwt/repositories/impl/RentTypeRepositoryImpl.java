package com.springBootNoJwt.repositories.impl;

import org.springframework.stereotype.Repository;

import com.springBootNoJwt.repositories.RentTypeRepository;
import com.springBootNoJwt.repositories.entity.RentTypeEntity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class RentTypeRepositoryImpl implements RentTypeRepository {
  @PersistenceContext
  private EntityManager entityManager;

  @Override
  public RentTypeEntity findById(Long id) {
    return this.entityManager.find(RentTypeEntity.class, id);
  }
}
