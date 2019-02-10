package com.dani.coupons.beans;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class UserLoginDetails {
	private String user;
	private String password;
	private String type;
	
	public UserLoginDetails() {
	}
	public UserLoginDetails(String user,String password) {
		this.user=user;
		this.password=password;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
