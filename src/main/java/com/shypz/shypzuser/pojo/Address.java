package com.shypz.shypzuser.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
@Table(name="Address",uniqueConstraints = {
		@UniqueConstraint(columnNames = "Address_Id")})
public class Address {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Address_Id",nullable=false)
	private long addressId;
	@Column(name="Address_Line",nullable=false,length=1000)
	private String addressLine;
	@Column(name="Address_Area",nullable=false,length=255)
	private String addressArea;
	@Column(name="Address_City",nullable=false,length=255)
	private String addressCity;
	@Column(name="Address_Pincode",nullable=false,length=45)
	private String addressPincode;
	@Column(name="Address_State",nullable=false,length=100)
	private String addressState;
	@Column(name="Address_Country",nullable=false,length=100)
	private String addressCountry;
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private User user;
	
	
	
	
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Address(long addressId, String addressLine, String addressArea, String addressCity, String addressPincode,
			String addressState, String addressCountry, User user) {
		super();
		this.addressId = addressId;
		this.addressLine = addressLine;
		this.addressArea = addressArea;
		this.addressCity = addressCity;
		this.addressPincode = addressPincode;
		this.addressState = addressState;
		this.addressCountry = addressCountry;
		this.user = user;
	}
	
	
	public long getAddressId() {
		return addressId;
	}
	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}
	public String getAddressLine() {
		return addressLine;
	}
	public void setAddressLine(String addressLine) {
		this.addressLine = addressLine;
	}
	public String getAddressArea() {
		return addressArea;
	}
	public void setAddressArea(String addressArea) {
		this.addressArea = addressArea;
	}
	public String getAddressCity() {
		return addressCity;
	}
	public void setAddressCity(String addressCity) {
		this.addressCity = addressCity;
	}
	public String getAddressPincode() {
		return addressPincode;
	}
	public void setAddressPincode(String addressPincode) {
		this.addressPincode = addressPincode;
	}
	public String getAddressState() {
		return addressState;
	}
	public void setAddressState(String addressState) {
		this.addressState = addressState;
	}
	public String getAddressCountry() {
		return addressCountry;
	}
	public void setAddressCountry(String addressCountry) {
		this.addressCountry = addressCountry;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	

}
