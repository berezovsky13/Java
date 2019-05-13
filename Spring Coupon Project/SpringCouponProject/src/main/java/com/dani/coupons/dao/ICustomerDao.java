package com.dani.coupons.dao;

import java.util.Collection;

import com.dani.coupons.beans.Customer;
import com.dani.coupons.exceptions.ApplicationException;

public interface ICustomerDao {

	public void CustomerCoupon()throws ApplicationException;

	public boolean login(String companyName, String password)throws ApplicationException;
	

	public void removeCustomer(long customerID)throws ApplicationException;
	
	public void updateCustomer(Customer customer)throws ApplicationException;
	
	public void createCustomer(Customer customer)throws ApplicationException;
	
	public Customer getCustomer(long customerID)throws ApplicationException;
	
	public Collection<Customer> getAllCustomers()throws ApplicationException;
	
	public boolean isEmailExists(String email)throws ApplicationException;

	boolean isCustomerExistByID(long customerID) throws ApplicationException;
	
	
}



