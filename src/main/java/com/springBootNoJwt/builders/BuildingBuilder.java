package com.springBootNoJwt.builders;

import java.util.List;

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
public class BuildingBuilder {
  private String name;
  private String ward;
  private String street;
  private Integer basementQuantity;
  private String direction;
  private String hang;
  private String managerName;
  private String managerPhone;
  private Long districtId;
  private Long employeeId;
  private List<String> rentTypes;
  private Long rentAreaFrom;
  private Long rentAreaTo;
  private Long rentPriceFrom;
  private Long rentPriceTo;
  private Integer floorAreaFrom;
  private Integer floorAreaTo;
}
