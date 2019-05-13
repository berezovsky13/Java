package com.dani.coupons.api;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dani.coupons.entities.CompanyEntity;
import com.dani.coupons.entities.CustomerEntity;
import com.dani.coupons.exceptions.ApplicationException;
import com.dani.coupons.logic.CustomerController;

@RestController
@RequestMapping(value="/customers")
public class CustomerApi {
	
	 
	
	
	
	@Autowired
	private CustomerController customerController;
	
	public CustomerApi () {
		this.customerController = new CustomerController();
	}
	

	
	
	@PostMapping("/createCustomer")
	public void createCustomer(@RequestBody CustomerEntity customer) throws ApplicationException{
		this.customerController.createCustomer(customer);
	}
	


	
	
	@PutMapping
	public void updateCustomer(HttpServletRequest req,@RequestBody CustomerEntity customer) throws ApplicationException {
		customerController.createCustomer(customer);
	}

	@DeleteMapping
	public void removeCustomer(HttpServletRequest req,@PathVariable("id") long id) throws ApplicationException {
		customerController.removeCustomer(id);
	}
	
	
	
	
	
	
	
	
	@GetMapping
	public Collection<CustomerEntity> getAllCompanies(HttpServletRequest req) throws ApplicationException {
		return customerController.getAllCustomers();
	}
	
	
	
	
	
	
	
	

}

