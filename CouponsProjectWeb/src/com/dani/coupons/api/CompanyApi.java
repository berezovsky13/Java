package com.dani.coupons.api;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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

import com.dani.coupons.beans.Company;
import com.dani.coupons.beans.Customer;
import com.dani.coupons.exceptions.ApplicationException;
import com.dani.coupons.logic.CompanyController;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

@Path("/companies")
public class CompanyApi {
	
	private CompanyController companyController;
	
	public CompanyApi () {
		this.companyController = new CompanyController();
	}
	
	@GET
	@Path("/{companyID}")
	public Company getCompanyByCompanyID(@PathParam("companyID") long companyID) throws ApplicationException{
		return this.companyController.getCompanyByCompanyID(companyID);
	}
	
		
	@POST
	public void createCompany(Company company) throws ApplicationException{
		this.companyController.createCompany(company);
	}
		

	@PUT
	public void updateCompany(Company company) throws ApplicationException {
	this.companyController.updateCompany(company);
	
	}
	
	@DELETE
	@Path("/{companyID}")
	 public void removeCompany(@PathParam("companyID") long companyID) throws ApplicationException{
	
		this.companyController.removeCompany(companyID);
	}
	
	@GET
	@Path("/all")
	public Collection<Company> getAllCompanies() throws ApplicationException{
		
		List<Company> companies = new ArrayList<>();
		companies=(List<Company>) this.companyController.getAllCompanies();
		return companies;
	
	

	}	
}
