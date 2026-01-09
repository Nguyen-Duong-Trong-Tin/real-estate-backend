package com.springBootNoJwt.dtos.buildings.find;

import java.util.List;

import com.springBootNoJwt.dtos.districts.DistrictResponseDto;
import com.springBootNoJwt.dtos.rentAreas.rentAreaResponseDto;
import com.springBootNoJwt.dtos.rentTypes.RentTypeResponseDto;

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
public class BuildingFindResponseDto {
  private Long id;
  private String name;
  private String street;
  private String ward;
  private DistrictResponseDto district;
  private Integer basementQuantity;
  private String managerName;
  private String managerPhone;
  private Integer floorArea;
  private Integer serviceFee;
  private RentTypeResponseDto rentType;
  private List<rentAreaResponseDto> rentAreas;
}
