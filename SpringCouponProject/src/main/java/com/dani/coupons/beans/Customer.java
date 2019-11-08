package com.dani.coupons.beans;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Customer {

	private long customerID;
	private String customer_name;
	private String email;
	private String password;
	private List<Coupon>coupons;
	public Customer(String email,String customer_name, String password,List<Coupon>coupons) {
		super();
		this.customer_name = customer_name;
		this.email = email;
		this.password = password;
        this.coupons = coupons;
	}
	
	
	
	
	public Customer() {
		super();
	}




	public Customer(String email,long customerID, String customer_name, String password,List<Coupon>coupons) {
		super();
		this.customerID = customerID;
		this.customer_name = customer_name;
		this.email = email;
		this.password = password;
	    this.coupons = coupons;
	}




	public long getCustomerID() {
		return customerID;
	}




	public void setCustomerID(long customerID) {
		this.customerID = customerID;
	}




	public String getCustomer_name() {
		return customer_name;
	}




	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	public List<Coupon> getCoupons() {
		return coupons;
	}




	public void setCoupons(List<Coupon> coupons) {
		this.coupons = coupons;
	}




	@Override
	public String toString() {
		return "Customer [customerID=" + customerID + ", customer_name=" + customer_name + ", email=" + email
				+ ", password=" + password + ", coupons=" + coupons + "]";
	}




	
	
	

}
