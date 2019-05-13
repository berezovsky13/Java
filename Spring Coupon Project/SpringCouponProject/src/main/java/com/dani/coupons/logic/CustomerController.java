package com.dani.coupons.logic;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.dani.coupons.dao.CompanyDaoJPA;
import com.dani.coupons.dao.CustomerDao;
import com.dani.coupons.dao.CustomerDaoJPA;
import com.dani.coupons.entities.CompanyEntity;
import com.dani.coupons.entities.CustomerEntity;
import com.dani.coupons.exceptions.ApplicationException;
import com.dani.coupons.Enums.ErrorType;
import com.dani.coupons.beans.Customer;
import com.dani.coupons.utilities.DateUtils;
import com.dani.coupons.utilities.LoginCheckList;

@Controller
public class CustomerController {

	@Autowired
	private CustomerDaoJPA customerDaoJpa;
	
	
	public CustomerController() {
		this.customerDaoJpa = new CustomerDaoJPA();
	}

	
 
	
	//Create company with JPA.
	public void createCustomer(CustomerEntity customer) throws ApplicationException{
		
		customerDaoJpa.createCustomer(customer);
	}
	
//Updating our company 
	public void updateCustomer(CustomerEntity customer)throws ApplicationException {
		
		customerDaoJpa.updateCustomer(customer);
	}
	
	//Removing company 
	public void removeCustomer(long id) throws ApplicationException{
		
		this.customerDaoJpa.removeCustomer(id);
	}
	
	
	public CustomerEntity getCustomerById(long id) throws ApplicationException {

		return customerDaoJpa.getCustomerById(id);
	}
	

	
	//get all companies
	public Collection<CustomerEntity> getAllCustomers() throws ApplicationException{
		return customerDaoJpa.getAllCustomers();
	}
	
	


	
	
	
	
}


