package com.dani.coupons.api;

import java.util.Collection;

//import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.dani.coupons.beans.Customer;
import com.dani.coupons.exceptions.ApplicationException;
import com.dani.coupons.logic.CompanyController;
import com.dani.coupons.logic.CustomerController;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)


@Path("/customers")
public class CustomerApi {
	 private CustomerController customerController;
	
	public CustomerApi () {
		this.customerController = new CustomerController();
	}
	
	@POST
	public void createCustomer(Customer customer) throws ApplicationException{
		this.customerController.createCustomer(customer);
	}
	@DELETE
	@Path("/{customerID}")
	 public void removeCompany(@PathParam("customerID") long customerID) throws ApplicationException{
	
		this.customerController.removeCustomer(customerID);
	}
	@GET
	@Path("/{customerID}")
	public void getCustomer(@PathParam("customerID") long customerID) throws ApplicationException{
		customerController.getCustomer(customerID);
	}
	
	@PUT	
	public void updateCustomer(Customer customer) throws ApplicationException{
		this.customerController.updateCustomer(customer);
	}
	
	
	@GET
	@Path("/all")
	public Collection<Customer> getAllCustomers() throws ApplicationException{
		return this.customerController.getAllCustomers();
	}
	
	
	
	
}
