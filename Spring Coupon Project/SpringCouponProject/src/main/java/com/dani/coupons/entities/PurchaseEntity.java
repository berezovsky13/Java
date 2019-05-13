package com.dani.coupons.entities;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="purchases")
public class PurchaseEntity {

	@Id
	@GeneratedValue
	long id;

	@ManyToOne
	private CustomerEntity customer;
	
	@ManyToOne
	private CouponEntity coupon;
	
	@Column(name="amount")
	private int amount;
	
	@Column(name="purchase_date", nullable=false)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
	private Date purchaseDate;

	//-----------------------------Constructors---------------------------------------

	public PurchaseEntity() {
	}

	public PurchaseEntity(CustomerEntity customer, CouponEntity coupon, int amount, Date purchaseDate) {
		this.customer = customer;
		this.coupon = coupon;
		this.amount = amount;
		this.purchaseDate = purchaseDate;
	}

	public PurchaseEntity(long id, CustomerEntity customer, CouponEntity coupon, int amount, Date purchaseDate) {
		this.id = id;
		this.customer = customer;
		this.coupon = coupon;
		this.amount = amount;
		this.purchaseDate = purchaseDate;
	}
	
	//-----------------------------Getters and Setters---------------------------------------

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public CustomerEntity getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerEntity customer) {
		this.customer = customer;
	}

	public CouponEntity getCoupon() {
		return coupon;
	}

	public void setCoupon(CouponEntity coupon) {
		this.coupon = coupon;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	@Override
	public String toString() {
		return "PurchaseEntity [id=" + id + ", customer=" + customer + ", coupon=" + coupon + ", amount=" + amount
				+ ", purchaseDate=" + purchaseDate + "]";
	}
}