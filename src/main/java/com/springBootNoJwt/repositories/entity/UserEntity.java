package com.springBootNoJwt.repositories.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "`users`")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "userName", nullable = false, unique = true, length = 50)
  private String username;

  @Column(name = "password", nullable = false, length = 100)
  private String password;

  @Column(name = "fullName", nullable = false, length = 100)
  private String fullName;

  @Column(name = "status", nullable = false)
  private String status;

  @Column(name = "email", nullable = false, unique = true, length = 100)
  private String email;

  @ManyToMany
  @JoinTable(name = "userRoles", joinColumns = @JoinColumn(name = "userId", nullable = false), inverseJoinColumns = @JoinColumn(name = "roleId", nullable = false))
  List<RoleEntity> roles;
}
