package com.dani.coupons.beans;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Company {

	
	private long companyID;
	private String company_name;
	private String email;
	private String password;
	
	public Company() {
	}
	
	
	public Company(String company_name, String email, String password) {
		super();
		this.company_name = company_name;
		this.email = email;
		this.password = password;
		
	}
	
	public Company(long companyID, String company_name, String password, String email) {
		this(company_name, password, email);
		this.companyID = companyID;
	}


	public long getCompanyID() {
		return companyID;
	}


	public void setCompanyID(long companyID) {
		this.companyID = companyID;
	}


	public String getCompany_name() {
		return company_name;
	}


	public void setCompany_name(String company_name) {
		this.company_name = company_name;
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


	@Override
	public String toString() {
		return "Company [companyID=" + companyID + ", company_name=" + company_name + ", email=" + email + ", password="
				+ password + "]";
	}

	
	
}
