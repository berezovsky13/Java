package com.dani.coupons.beans;

import javax.xml.bind.annotation.XmlRootElement;

import com.dani.coupons.Enums.CouponType;

@XmlRootElement
public class Coupon {

	private long couponID;
	private String title;
	private int amount;
	private double price;
	private String startDate;
	private String endDate;
	private String message;
	private String image;
	private CouponType type;
	private long companyID;
	public Coupon() {
		// TODO Auto-generated constructor stub
	}
	public Coupon(String title, int amount, double price, String startDate, String endDate, String message,
			String image, CouponType type,long companyID) {
		super();
		this.title = title;
		this.amount = amount;
		this.price =  price;
		this.startDate = startDate;
		this.endDate = endDate;
		this.message = message;
		this.image = image;
		this.type = type;
        this.companyID = companyID;
}
	public Coupon(long couponID, String title, int amount, double price, String startDate, String endDate, String message,
			String image, CouponType type,long companyID) {
		super();
		this.couponID = couponID;
		this.title = title;
		this.amount = amount;
		this.price = price;
		this.startDate = startDate;
		this.endDate = endDate;
		this.message = message;
		this.image = image;
		this.type = type;
		this.companyID = companyID;
	}
	public long getCouponID() {
		return couponID;
	}
	public void setCouponID(long couponID) {
		this.couponID = couponID;
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
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
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public CouponType getType() {
		return type;
	}
	public void setType(CouponType type) {
		this.type = type;
	}
	public long getCompanyID() {
		return companyID;
	}
	public void setCompanyID(long companyID) {
		this.companyID = companyID;
	}
	@Override
	public String toString() {
		return "Coupon [couponID=" + couponID + ", title=" + title + ", amount=" + amount + ", price=" + price
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", message=" + message + ", image=" + image
				+ ", type=" + type + ", companyID=" + companyID + "]";
	}
	
	

	
	}

