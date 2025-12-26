package com.springBootNoJwt.builders;

import java.util.List;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class BuildingBuilder {
  private String name;
  private String ward;
  private String street;
  private Integer basementQuantity;
  private String direction;
  private String hang;
  private String managerName;
  private String managerPhone;
  private String districtId;
  private String employeeId;
  private List<String> rentTypes;
  private Integer rentAreaFrom;
  private Integer rentAreaTo;
  private Long rentPriceFrom;
  private Long rentPriceTo;
  private Integer floorAreaFrom;
  private Integer floorAreaTo;
}
