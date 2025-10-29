package com.springBootNoJwt.interfaces;

public class IBuilding {
	private String houseId;
	private String name;
	private String ward;
	private String street;
	private String structure;
	private int basementQuantity;
	private int floorArea;
	private String direction;
	private String hang;
	private String rentalArea;
	private String rentalPrice;
	private String priceDescription;
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
	
	public IBuilding() {}
	
	public IBuilding(String houseId, String name, String ward, String street, String structure, int basementQuantity,
			int floorArea, String direction, String hang, String rentalArea, String rentalPrice,
			String priceDescription, int serviceFee, int carFees, int motorcycleFee, int overtimeFee,
			int electricityBill, int deposit, int pay, int rentalPeriod, int decoratorTime, String managerName,
			String managerPhone, int brokerageFees, String buildingType, String note) {
		super();
		this.houseId = houseId;
		this.name = name;
		this.ward = ward;
		this.street = street;
		this.structure = structure;
		this.basementQuantity = basementQuantity;
		this.floorArea = floorArea;
		this.direction = direction;
		this.hang = hang;
		this.rentalArea = rentalArea;
		this.rentalPrice = rentalPrice;
		this.priceDescription = priceDescription;
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
	
	public String getRentalArea() {
		return rentalArea;
	}
	
	public void setRentalArea(String rentalArea) {
		this.rentalArea = rentalArea;
	}
	
	public String getRentalPrice() {
		return rentalPrice;
	}
	
	public void setRentalPrice(String rentalPrice) {
		this.rentalPrice = rentalPrice;
	}
	
	public String getPriceDescription() {
		return priceDescription;
	}
	
	public void setPriceDescription(String priceDescription) {
		this.priceDescription = priceDescription;
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
}
