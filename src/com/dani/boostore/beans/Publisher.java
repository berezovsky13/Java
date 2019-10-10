package com.dani.boostore.beans;

public class Publisher {

	
	private long publisherID;
	private String publisherName;
	private String email;
	private String password;
	public long getPublisherID() {
		return publisherID;
	}
	public void setPublisherID(long publisherID) {
		this.publisherID = publisherID;
	}
	public String getPublisherName() {
		return publisherName;
	}
	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
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
		return "Publisher [publisherID=" + publisherID + ", publisherName=" + publisherName + ", email=" + email
				+ ", password=" + password + "]";
	}
	
	
	
}
