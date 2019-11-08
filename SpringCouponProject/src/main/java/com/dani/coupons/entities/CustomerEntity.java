package com.dani.coupons.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;





@Entity
@Table(name="customers")
public class CustomerEntity implements Serializable{

//	@Id
//	@Column(name="CUSTOMER_ID")
//	private long customerId;
//
//	@OneToOne
//	private UserLoginDetailsEntity userLoginDetails;
	

	@Id
	@OneToOne
	private UserLoginDetailsEntity userLoginDetails;
	
	@Column(name="ADDRESS")
	private String address;
	
	@Column(name="AMOUNT_OF_KIDS")
	private int amountOfKids;
	
	@Column(name="PHONE_NUMBER")
	private String phoneNumber;
	
	@OneToMany(cascade=CascadeType.REMOVE, mappedBy="customer")
	private List<PurchaseEntity> purchases;
	
	public CustomerEntity() {
	}
	
	public CustomerEntity(UserLoginDetailsEntity userLoginDetails, String address, int amountOfKids,
			String phoneNumber) {
		super();
		this.userLoginDetails = userLoginDetails;
		this.address = address;
		this.amountOfKids = amountOfKids;
		this.phoneNumber = phoneNumber;
	}
	
	
	public UserLoginDetailsEntity getUserLoginDetails() {
		return userLoginDetails;
	}
	public void setUserLoginDetails(UserLoginDetailsEntity userLoginDetails) {
		this.userLoginDetails = userLoginDetails;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getAmountOfKids() {
		return amountOfKids;
	}
	public void setAmountOfKids(int amountOfKids) {
		this.amountOfKids = amountOfKids;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "CustomerEntity [userLoginDetails=" + userLoginDetails + ", address=" + address + ", amountOfKids="
				+ amountOfKids + ", phoneNumber=" + phoneNumber + ", purchases=" + purchases + "]";
	}
	


	
	

	
	
} 
