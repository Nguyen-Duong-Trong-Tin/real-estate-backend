package com.springBootNoJwt.repositories.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "buildings")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BuildingEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name", nullable = false, length = 100)
	private String name;
	
	@Column(name = "ward", nullable = false, length = 100)
	private String ward;

	@Column(name = "street", nullable = false, length = 100)
	private String street;

	@Column(name = "structure", length = 100)
	private String structure;

	@Column(name = "basementQuantity")
	private Integer basementQuantity;

	@Column(name = "floorArea", nullable = false)
	private Integer floorArea;

	@Column(name = "direction", length = 100)
	private String direction;

	@Column(name = "class", length = 100)
	private String hang;

	@Column(name = "serviceFee")
	private Integer serviceFee;

	@Column(name = "carFees")
	private Integer carFees;

	@Column(name = "motorcycleFee")
	private Integer motorcycleFee;

	@Column(name = "overtimeFee")
	private Integer overtimeFee;

	@Column(name = "electricityBill")
	private Integer electricityBill;

	@Column(name = "deposit")
	private Integer deposit;

	@Column(name = "pay")
	private Integer pay;

	@Column(name = "rentalPeriod")
	private Integer rentalPeriod;

	@Column(name = "decoratorTime")
	private Integer decoratorTime;

	@Column(name = "managerName", length = 100)
	private String managerName;

	@Column(name = "managerPhone", length = 15)
	private String managerPhone;

	@Column(name = "brokerageFees")
	private Integer brokerageFees;

	@Column(name = "buildingType", length = 100)
	private String buildingType;

	@Column(name = "note", length = 500)
	private String note;

	@ManyToOne()
	@JoinColumn(name = "districtId", nullable = false)
	private DistrictEntity district;	

	@ManyToOne()
	@JoinColumn(name = "rentTypeId", nullable = false)
	private RentTypeEntity rentType;
	
	@OneToMany(mappedBy = "building")
	private List<RentAreaEntity> rentAreas;
}