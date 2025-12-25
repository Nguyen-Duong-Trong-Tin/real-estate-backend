package com.springBootNoJwt.dtos.buildings;

import java.util.List;

import com.springBootNoJwt.dtos.districts.DistrictResponseDto;
import com.springBootNoJwt.dtos.rentTypes.RentTypeResponseDto;

public class BuildingResponseDto {
	private String id;
	private String name;
	private String street;
	private String ward;
	private String districtId;
	private DistrictResponseDto district;
	private int numberOfBasement;
	private String managerName;
	private String managerPhone;
	private int floorArea;
	private int rentalPrice;
	private int serviceFee;
	private String rentTypeCode;
	private RentTypeResponseDto rentType;
	private List<Integer> rentAreas;

	public BuildingResponseDto() {
		super();
		this.id = "";
		this.name = "";
		this.street = "";
		this.ward = "";
		this.districtId = "";
		this.numberOfBasement = 0;
		this.managerName = "";
		this.managerPhone = "";
		this.floorArea = 0;
		this.rentalPrice = 0;
		this.serviceFee = 0;
		this.rentTypeCode = "";
	}

	public BuildingResponseDto(String id, String name, String street, String ward, String districtId,
			int numberOfBasement, String managerName, String managerPhone, int floorArea,
			int rentalPrice, int serviceFee, String rentTypeCode) {
		super();
		this.id = id;
		this.name = name;
		this.street = street;
		this.ward = ward;
		this.districtId = districtId;
		this.numberOfBasement = numberOfBasement;
		this.managerName = managerName;
		this.managerPhone = managerPhone;
		this.floorArea = floorArea;
		this.rentalPrice = rentalPrice;
		this.serviceFee = serviceFee;
		this.rentTypeCode = rentTypeCode;
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

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getWard() {
		return ward;
	}

	public void setWard(String ward) {
		this.ward = ward;
	}

	public String getDistrictId() {
		return districtId;
	}

	public void setDistrictId(String districtId) {
		this.districtId = districtId;
	}

	public DistrictResponseDto getDistrict() {
		return district;
	}

	public void setDistrict(DistrictResponseDto district) {
		this.district = district;
	}

	public int getNumberOfBasement() {
		return numberOfBasement;
	}

	public void setNumberOfBasement(int numberOfBasement) {
		this.numberOfBasement = numberOfBasement;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getManagerPhone() {
		return managerPhone;
	}

	public void setManagerPhone(String managerPhone) {
		this.managerPhone = managerPhone;
	}

	public int getFloorArea() {
		return floorArea;
	}

	public void setFloorArea(int floorArea) {
		this.floorArea = floorArea;
	}

	public int getRentalPrice() {
		return rentalPrice;
	}

	public void setRentalPrice(int rentalPrice) {
		this.rentalPrice = rentalPrice;
	}

	public int getServiceFee() {
		return serviceFee;
	}

	public void setServiceFee(int serviceFee) {
		this.serviceFee = serviceFee;
	}

	public String getRentTypeCode() {
		return rentTypeCode;
	}

	public void setRentTypeCode(String rentTypeCode) {
		this.rentTypeCode = rentTypeCode;
	}

	public RentTypeResponseDto getRentType() {
		return rentType;
	}

	public void setRentType(RentTypeResponseDto rentType) {
		this.rentType = rentType;
	}

	public List<Integer> getRentAreas() {
		return rentAreas;
	}

	public void setRentAreas(List<Integer> rentAreas) {
		this.rentAreas = rentAreas;
	}
}
