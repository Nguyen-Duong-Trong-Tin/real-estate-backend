package com.springBootNoJwt.dtos.rentTypes;

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
public class RentTypeResponseDto {
  private String id;
  private String code;
  private String name;
}
