package com.dani.coupons.logic;

import java.util.Collection;

import org.springframework.stereotype.Service;

import com.dani.coupons.dao.CustomerDao;
import com.dani.coupons.exceptions.ApplicationException;
import com.dani.coupons.Enums.ErrorType;
import com.dani.coupons.beans.Customer;
import com.dani.coupons.utilities.DataValidationUtils;
import com.dani.coupons.utilities.DateUtils;
import com.dani.coupons.utilities.LoginCheckList;

@Service
public class CustomerService {

	
	private CustomerDao customerDao;
	
	//Constructor
	public CustomerService() {
		this.customerDao = new CustomerDao();
		
	customerDao = new CustomerDao();
	}
	
	
	
	
	//Creating/adding a new Customer 
	public void createCustomer (Customer customer)throws ApplicationException {
		validateCreateCustomer(customer);
		customerDao.createCustomer(customer);
	}
	
	private void validateCreateCustomer(Customer customer) throws ApplicationException{
		if(customerDao.isCustomerExistByName(customer.getCustomer_name())) {
			throw new ApplicationException(ErrorType.WRONG_INPUT,DateUtils.getCurrentDateAndTime() + " Name cannot be replaced ");
		}
		if(!customerDao.isEmailExists(customer.getEmail())) {
			throw new ApplicationException(ErrorType.WRONG_INPUT,DateUtils.getCurrentDateAndTime() + " E-mail Already Exists  " );
		}
		if(!(customer.getPassword().length()<0)&&customer.getPassword().length()<100) {
			throw new ApplicationException(ErrorType.WRONG_INPUT,DateUtils.getCurrentDateAndTime() + " Invalid Password Length ");
		}
	}
	
	
	//Updating Customer 
	public void updateCustomer (Customer customer)throws ApplicationException {
	validateUpdateCustomer(customer);
	customerDao.updateCustomer(customer);
	}
	
	
	private void validateUpdateCustomer (Customer customer)throws ApplicationException{
		if (!DataValidationUtils.validateEmail(customer.getEmail())) {
			throw new ApplicationException(ErrorType.WRONG_INPUT,DateUtils.getCurrentDateAndTime() + " Failed to update Company - invalid email");	
		}
		if(!(customer.getPassword().length() > 0) && customer.getPassword().length() < 200) {
			throw new ApplicationException(ErrorType.WRONG_INPUT,DateUtils.getCurrentDateAndTime() + " Failed to update Company - illegal password");
		}
	}
	
	//Removing/deleting Customer
	public void removeCustomer (long customerID)throws ApplicationException {
		
		if(!customerDao.isCustomerExistByID(customerID)) {
		
			
			throw new ApplicationException(ErrorType.GENERAL_ERROR,DateUtils.getCurrentDateAndTime() + "Failed to remove Customer");
		}
		customerDao.removeCustomer(customerID);
	}
	
	//Getting customer 
	public Customer getCustomer (long customerID)throws ApplicationException {
		if (!customerDao.isCustomerExistByID(customerID)) {
			throw new ApplicationException(ErrorType.GENERAL_ERROR,DateUtils.getCurrentDateAndTime() + "Failed to get the Customer");
		} 
			return	customerDao.getCustomer(customerID);
		
		
	}
	
	//Getting a collection of all Customers
	public Collection<Customer> getAllCustomers ()throws ApplicationException {
		return customerDao.getAllCustomers();
	}
	
	
	
}


