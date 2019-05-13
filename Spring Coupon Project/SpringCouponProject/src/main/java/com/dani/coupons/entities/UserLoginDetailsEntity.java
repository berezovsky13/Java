package com.dani.coupons.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.usertype.UserType;

@Entity
@Table(name="user_login_details")
public class UserLoginDetailsEntity {
	
	@Id
	@GeneratedValue
	@Column(name="USER_ID")
	private long id;
	
	@OneToOne
	private CompanyEntity company;
	
	// We expect the user to provide his email as his user name, validation will be 
	// carried out accordingly
	@Column(name="user_name")
	private String userName;
	
	@Column(name="password")
	private String password;
	
	@Column(name="type")
	@Enumerated(EnumType.STRING)
	private UserType userType;

	public UserLoginDetailsEntity() {
		super();
	}

	public UserLoginDetailsEntity(CompanyEntity company, String userName, String password, UserType userType) {
		super();
		this.company = company;
		this.userName = userName;
		this.password = password;
		this.userType = userType;
	}



	public UserLoginDetailsEntity(long id, CompanyEntity company, String userName, String password, UserType userType) {
		super();
		this.id = id;
		this.company = company;
		this.userName = userName;
		this.password = password;
		this.userType = userType;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}
}