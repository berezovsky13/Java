package com.dani.coupons.logic;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.dani.coupons.dao.CompanyDao;
import com.dani.coupons.dao.CompanyDaoJPA;
import com.dani.coupons.entities.CompanyEntity;
import com.dani.coupons.dao.CompanyDao;
import com.dani.coupons.exceptions.ApplicationException;
import com.dani.coupons.utilities.DataValidationUtils;
import com.dani.coupons.utilities.DateUtils;
import com.dani.coupons.Enums.ErrorType;
import com.dani.coupons.beans.Company;

@Controller
public class CompanyController {
	


	@Autowired
	private CompanyDaoJPA companyDaoJpa;
	
	
	public CompanyController() {
		this.companyDaoJpa = new CompanyDaoJPA();
	}

	
 
	
	//Create company with JPA.
	public void createCompany(CompanyEntity company) throws ApplicationException{
		validateCreateCompany(company);
		companyDaoJpa.createCompany(company);
	}
	
	
	private void validateCreateCompany(CompanyEntity company) throws ApplicationException{
		if(!(company.getPhone().length()>0&&company.getPhone().length()<15)) {
			throw new ApplicationException(ErrorType.WRONG_INPUT,DateUtils.getCurrentDateAndTime() + "Phone number is invalid ");
	}
	
		if(companyDaoJpa.isCompanyExist(company.getId())) {
            throw new ApplicationException(ErrorType.ALREADY_EXISTS,DateUtils.getCurrentDateAndTime() + " Company with this id already exists ");
		}
	
	
	}
	
	

//Updating our company using JPA/Hibernate.
	public void updateCompany(CompanyEntity company)throws ApplicationException {
		validateUpdateCompany(company);
		companyDaoJpa.updateCompany(company);
	}
	
	private void validateUpdateCompany(CompanyEntity company) throws ApplicationException{
		if(!(company.getPhone().length()>0&&company.getPhone().length()<15)) {
			throw new ApplicationException(ErrorType.WRONG_INPUT,DateUtils.getCurrentDateAndTime() + "Phone number is invalid ");
	}
	
		if(!companyDaoJpa.isCompanyExist(company.getId())) {
            throw new ApplicationException(ErrorType.ALREADY_EXISTS,DateUtils.getCurrentDateAndTime() + " Company with this id does not exists ");
		}
	}
	
	
	
	


	
	//Removing company with JPA
	public void removeCompany(long id) throws ApplicationException{
		if(!companyDaoJpa.isCompanyExist(id)) {
			throw new ApplicationException(ErrorType.DATA_NOT_FOUND,DateUtils.getCurrentDateAndTime() + " Failed to remove company id ");
		}
		companyDaoJpa.removeCompany(id);
	}
	

	
	//get all companies in JPA
	public Collection<CompanyEntity> getAllCompanies() throws ApplicationException{
		return companyDaoJpa.getAllCompanies();
	}
	
	
	public CompanyEntity getCompanyById(long id) throws ApplicationException {

		return companyDaoJpa.getByIdCompany(id);
	}

	
}
