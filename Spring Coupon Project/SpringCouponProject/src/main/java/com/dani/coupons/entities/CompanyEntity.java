package com.dani.coupons.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.dani.coupons.beans.Company;

@Entity
@Table(name="companies")
public class CompanyEntity {

	
	
	public CompanyEntity() {
		super();
	}

	
	
	
	public CompanyEntity(long id, String company_name, String address, String phone, CompanyEntity father,
			List<CompanyEntity> kids) {
		super();
		this.id = id;
		this.company_name = company_name;
		this.address = address;
		this.phone = phone;
		this.father = father;
		this.kids = kids;
	}




	public CompanyEntity(String company_name, String addresss, String phone) {
		super();
		this.company_name = company_name;
		this.address = address;
		this.phone = phone;
	}



	@GeneratedValue
	@Id
	private long id;
	
	@Column(name="company_name", nullable=false, unique=true)
	private String company_name;
	
	@Column(name="address",nullable=false)
    private String address;

	@Column(name="phone",nullable=false)
    private String phone;
	
 
	@ManyToOne
	private CompanyEntity father;
	
	@OneToMany(cascade={CascadeType.PERSIST,CascadeType.MERGE},mappedBy="father", fetch = FetchType.LAZY)
	private List<CompanyEntity> kids;

	




	public long getId() {
		return id;
	}




	public void setCompanyId(long id) {
		
		id = id;
	}




	public String getCompany_name() {
		return company_name;
	}




	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}




	public String getAddress() {
		return address;
	}




	public void setAddress(String address) {
		this.address = address;
	}




	public String getPhone() {
		return phone;
	}




	public void setPhone(String phone) {
		this.phone = phone;
	}




	public CompanyEntity getFather() {
		return father;
	}




	public void setFather(CompanyEntity father) {
		this.father = father;
	}




	public List<CompanyEntity> getKids() {
		return kids;
	}




	public void setKids(List<CompanyEntity> kids) {
		this.kids = kids;
	}




	@Override
	public String toString() {
		return "CompanyEntity [id=" + id + ", company_name=" + company_name + ", address=" + address + ", phone="
				+ phone + ", father=" + father + ", kids=" + kids + "]";
	}


	
	
	
	
	

}
