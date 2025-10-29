package com.springBootNoJwt.dtos.buildings;

public class FindBuildingsResponseDto {
	private String houseId;
	private String name;
	private String ward;
	private String street;
	
	public FindBuildingsResponseDto() {
		this.houseId = "";
		this.name = "";
		this.ward = "";
		this.street = "";
	}
	
	public FindBuildingsResponseDto(String houseId, String name, String ward, String street) {
		super();
		this.houseId = houseId;
		this.name = name;
		this.ward = ward;
		this.street = street;
	}
	
	public String getHouseId() {
		return houseId;
	}

	public void setHouseId(String houseId) {
		this.houseId = houseId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWard() {
		return ward;
	}

	public void setWard(String ward) {
		this.ward = ward;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}
}
