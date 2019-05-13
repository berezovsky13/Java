package com.dani.coupons.entities;

import java.sql.Date;
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


import com.dani.coupons.Enums.CouponType;

@Entity
@Table(name="coupons")
public class CouponEntity {
	
	@Id
	@GeneratedValue
	private long id;
	
	@Column(name="title")
	private String title;
	
	@Column(name="amount")
	private int amount;
	
	@Column(name="price")
	private float price;
	
	@Column(name="description")
	private String description;
	
	@Column(name="start_date")
	private String startDate;
	
	@Column(name="end_date")
	private String endDate;
	
	@ManyToOne
	private CompanyEntity company; 
	
	public CouponEntity(long id, String title, int amount, float price, String description, String startdate,
			String enddate) {
		super();
		this.id = id;
		this.title = title;
		this.amount = amount;
		this.price = price;
		this.description = description;
		this.startDate = startdate;
		this.endDate = enddate;
	}
	
	public CouponEntity(String title, int amount, float price, String description, String startDate,
			String endDate) {
		super();
		this.title = title;
		this.amount = amount;
		this.price = price;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	public CouponEntity() {
	}

	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public CompanyEntity getCompany() {
		return company;
	}

	public void setCompany(CompanyEntity company) {
		this.company = company;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CouponEntity other = (CouponEntity) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CouponEntity [id=" + id + ", title=" + title + ", amount=" + amount + ", price=" + price
				+ ", description=" + description + ", startDate=" + startDate + ", endDate=" + endDate + ", company="
				+ company + "]";
	}

	




}

