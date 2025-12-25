package com.springBootNoJwt.dtos.rentTypes;

public class RentTypeResponseDto {
  private String id;
  private String rentTypeCode;
  private String name;

  public RentTypeResponseDto() {
    super();
    
    this.id = "";
    this.rentTypeCode = "";
    this.name = "";
  }

  public RentTypeResponseDto(String id, String rentTypeCode, String name) {
    super();

    this.id = id;
    this.rentTypeCode = rentTypeCode;
    this.name = name;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getRentTypeCode() {
    return rentTypeCode;
  }

  public void setRentTypeCode(String rentTypeCode) {
    this.rentTypeCode = rentTypeCode;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
  
}
