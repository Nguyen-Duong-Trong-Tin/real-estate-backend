package com.springBootNoJwt.repositories.entity;

import java.util.List;

public class BuildingEntity {
	private String id;
	private String name;
	private String ward;
	private String street;
	private String districtId;
	private DistrictEntity district;
	private String structure;
	private int basementQuantity;
	private int floorArea;
	private String direction;
	private String hang;
	private int serviceFee;
	private int carFees;
	private int motorcycleFee;
	private int overtimeFee;
	private int electricityBill;
	private int deposit;
	private int pay;
	private int rentalPeriod;
	private int decoratorTime;
	private String managerName;
	private String managerPhone;
	private int brokerageFees;
	private String buildingType;
	private String note;
	private String rentTypeCode;
	private RentTypeEntity rentType;
	private List<Integer> rentAreas;

	public BuildingEntity() {
		super();
		this.id = "";
		this.name = "";
		this.ward = "";
		this.street = "";
		this.districtId = "";
		this.structure = "";
		this.basementQuantity = 0;
		this.floorArea = 0;
		this.direction = "";
		this.hang = "";
		this.serviceFee = 0;
		this.carFees = 0;
		this.motorcycleFee = 0;
		this.overtimeFee = 0;
		this.electricityBill = 0;
		this.deposit = 0;
		this.pay = 0;
		this.rentalPeriod = 0;
		this.decoratorTime = 0;
		this.managerName = "";
		this.managerPhone = "";
		this.brokerageFees = 0;
		this.buildingType = "";
		this.note = "";
		this.rentTypeCode = "";
	}

	public BuildingEntity(String id, String name, String ward, String street, String districtId, String structure,
			int basementQuantity,
			int floorArea, String direction, String hang,
			int serviceFee, int carFees, int motorcycleFee, int overtimeFee,
			int electricityBill, int deposit, int pay, int rentalPeriod, int decoratorTime, String managerName,
			String managerPhone, int brokerageFees, String buildingType, String note, String rentTypeCode) {
		super();
		this.id = id;
		this.name = name;
		this.ward = ward;
		this.street = street;
		this.districtId = districtId;
		this.structure = structure;
		this.basementQuantity = basementQuantity;
		this.floorArea = floorArea;
		this.direction = direction;
		this.hang = hang;
		this.serviceFee = serviceFee;
		this.carFees = carFees;
		this.motorcycleFee = motorcycleFee;
		this.overtimeFee = overtimeFee;
		this.electricityBill = electricityBill;
		this.deposit = deposit;
		this.pay = pay;
		this.rentalPeriod = rentalPeriod;
		this.decoratorTime = decoratorTime;
		this.managerName = managerName;
		this.managerPhone = managerPhone;
		this.brokerageFees = brokerageFees;
		this.buildingType = buildingType;
		this.note = note;
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

	public String getDistrictId() {
		return districtId;
	}

	public void setDistrictId(String districtId) {
		this.districtId = districtId;
	}

	public DistrictEntity getDistrict() {
		return district;
	}

	public void setDistrict(DistrictEntity district) {
		this.district = district;
	}

	public String getStructure() {
		return structure;
	}

	public void setStructure(String structure) {
		this.structure = structure;
	}

	public int getBasementQuantity() {
		return basementQuantity;
	}

	public void setBasementQuantity(int basementQuantity) {
		this.basementQuantity = basementQuantity;
	}

	public int getFloorArea() {
		return floorArea;
	}

	public void setFloorArea(int floorArea) {
		this.floorArea = floorArea;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getHang() {
		return hang;
	}

	public void setHang(String hang) {
		this.hang = hang;
	}

	public int getServiceFee() {
		return serviceFee;
	}

	public void setServiceFee(int serviceFee) {
		this.serviceFee = serviceFee;
	}

	public int getCarFees() {
		return carFees;
	}

	public void setCarFees(int carFees) {
		this.carFees = carFees;
	}

	public int getMotorcycleFee() {
		return motorcycleFee;
	}

	public void setMotorcycleFee(int motorcycleFee) {
		this.motorcycleFee = motorcycleFee;
	}

	public int getOvertimeFee() {
		return overtimeFee;
	}

	public void setOvertimeFee(int overtimeFee) {
		this.overtimeFee = overtimeFee;
	}

	public int getElectricityBill() {
		return electricityBill;
	}

	public void setElectricityBill(int electricityBill) {
		this.electricityBill = electricityBill;
	}

	public int getDeposit() {
		return deposit;
	}

	public void setDeposit(int deposit) {
		this.deposit = deposit;
	}

	public int getPay() {
		return pay;
	}

	public void setPay(int pay) {
		this.pay = pay;
	}

	public int getRentalPeriod() {
		return rentalPeriod;
	}

	public void setRentalPeriod(int rentalPeriod) {
		this.rentalPeriod = rentalPeriod;
	}

	public int getDecoratorTime() {
		return decoratorTime;
	}

	public void setDecoratorTime(int decoratorTime) {
		this.decoratorTime = decoratorTime;
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

	public int getBrokerageFees() {
		return brokerageFees;
	}

	public void setBrokerageFees(int brokerageFees) {
		this.brokerageFees = brokerageFees;
	}

	public String getBuildingType() {
		return buildingType;
	}

	public void setBuildingType(String buildingType) {
		this.buildingType = buildingType;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getRentTypeCode() {
		return rentTypeCode;
	}

	public void setRentTypeCode(String rentTypeCode) {
		this.rentTypeCode = rentTypeCode;
	}

	public RentTypeEntity getRentType() {
		return rentType;
	}

	public void setRentType(RentTypeEntity rentType) {
		this.rentType = rentType;
	}

	public List<Integer> getRentAreas() {
		return rentAreas;
	}

	public void setRentAreas(List<Integer> rentAreas) {
		this.rentAreas = rentAreas;
	}
}
