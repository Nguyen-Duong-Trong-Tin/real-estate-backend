package com.springBootNoJwt.repositories.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "`roles`")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RoleEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  @Column(name = "name", nullable = false, unique = true, length = 50)
  private String name;

  @Column(name = "code", nullable = false, unique = true, length = 20)
  private String code;

  @ManyToMany(mappedBy = "roles")
  List<UserEntity> users;
}
