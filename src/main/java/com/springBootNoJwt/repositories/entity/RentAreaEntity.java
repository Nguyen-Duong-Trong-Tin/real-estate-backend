package com.springBootNoJwt.repositories.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "`rentAreas`")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RentAreaEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "value", nullable = false)
  private Integer value;

  @Column(name = "price")
  private Long price;

  @Column(name = "unit", length = 50)
  private String unit;

  @ManyToOne()
  @JoinColumn(name = "buildingId", nullable = false)
  private BuildingEntity building;
}
