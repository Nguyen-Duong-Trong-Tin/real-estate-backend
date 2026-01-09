package com.springBootNoJwt.dtos.rentAreas;

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
public class rentAreaResponseDto {
  private Long id;
  private Integer value;
  private Long price;
  private String unit;
}
