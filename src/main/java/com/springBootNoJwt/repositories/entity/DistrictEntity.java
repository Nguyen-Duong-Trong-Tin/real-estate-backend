package com.springBootNoJwt.repositories.entity;

public class DistrictEntity {
  private String id;
  private String name;
  private String description;

  public DistrictEntity() {
    super();
    this.id = "";
    this.name = "";
    this.description = "";
  }

  public DistrictEntity(String id, String name, String description) {
    super();
    this.id = id;
    this.name = name;
    this.description = description;
  }

  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }
}
