package com.dani.coupons.api;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

//import javax.websocket.server.PathParam;
//import javax.ws.rs.Consumes;
//import javax.ws.rs.DELETE;
//import javax.ws.rs.GET;
//import javax.ws.rs.POST;
//import javax.ws.rs.PUT;
//import javax.ws.rs.Path;
//import javax.ws.rs.PathParam;
//import javax.ws.rs.Produces;
//import javax.ws.rs.QueryParam;
//import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.dani.coupons.beans.Company;
import com.dani.coupons.beans.Customer;
import com.dani.coupons.entities.CompanyEntity;
import com.dani.coupons.exceptions.ApplicationException;
import com.dani.coupons.logic.CompanyService;




@RestController
@RequestMapping(value="/companies")
public class CompanyApi {
	
	 
	
	
	
	@Autowired
	private CompanyService companyService;
	
	public CompanyApi () {
		this.companyService = new CompanyService();
	}
	

	
	
	@PostMapping("/createCompany")
	public void createCompany(@RequestBody Company company) throws ApplicationException{
		this.companyService.createCompany(company);
	}
	


	
	
	@PutMapping
	public void updateCompany(HttpServletRequest req,@RequestBody Company company) throws ApplicationException {
		companyService.updateCompany(company);
	}

	@DeleteMapping
	public void removeCompany(HttpServletRequest req,@PathVariable("id") long id) throws ApplicationException {
		companyService.removeCompany(id);
	}
	
	@GetMapping("/{id}")
	public Company getCompanyById (@PathVariable long id) throws ApplicationException {
		return companyService.getCompanyByCompanyID(id);
	}
	
	
	
	
	
	
	@GetMapping
	public Collection<Company> getAllCompanies(HttpServletRequest req) throws ApplicationException {
		return companyService.getAllCompanies();
	}
	
	
	
	
	
	
	
	

}
