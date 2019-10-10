package com.dani.boostore.beans;

public class Customer {
	private long customerID;
	private String customer_name;
	private String email;
	private String password;
	public Customer(String email,String customer_name, String password) {
		super();
		this.customer_name = customer_name;
		this.email = email;
		this.password = password;

	}
	
	
	
	
	public Customer() {
		super();
	}




	public Customer(String email,long customerID, String customer_name, String password) {
		super();
		this.customerID = customerID;
		this.customer_name = customer_name;
		this.email = email;
		this.password = password;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
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




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	@Override
	public String toString() {
		return "Customer [email=" + email + ", customerID=" + customerID + ", customer_name=" + customer_name
				+ ", password=" + password + "]";
	}
	
}
