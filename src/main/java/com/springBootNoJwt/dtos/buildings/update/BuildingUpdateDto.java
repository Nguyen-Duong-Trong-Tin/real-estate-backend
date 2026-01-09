package com.springBootNoJwt.dtos.buildings.update;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BuildingUpdateDto {
  private String name;
  private String ward;
  private String street;
  private String structure;
  private Integer basementQuantity;
  private Integer floorArea;
  private String direction;
  private String hang;
  private Integer serviceFee;
  private Integer carFees;
  private Integer motorbikeFees;
  private Integer overtimeFees;
  private Integer electricityBill;
  private Integer deposit;
  private Integer pay;
  private Integer rentalPeriod;
  private Integer decoratorTime;
  private String managerName;
  private String managerPhone;
  private Integer brokerageFees;
  private String buildingType;
  private String note;
  private Long districtId;
  private Long rentTypeId;
}
