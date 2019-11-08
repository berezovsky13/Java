package com.dani.coupons.logic;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dani.coupons.dao.CompanyDao;
import com.dani.coupons.exceptions.ApplicationException;
import com.dani.coupons.utilities.DataValidationUtils;
import com.dani.coupons.utilities.DateUtils;
import com.dani.coupons.Enums.ErrorType;
import com.dani.coupons.beans.Company;

@Service
public class CompanyService {
	private CompanyDao  companyDao;

	//Constructor
	public CompanyService() {
		this.companyDao = new CompanyDao();
	}

	//Creating company
	public void createCompany(Company company) throws ApplicationException {
		validateCreateCompany(company);
		companyDao.createCompany(company);	
	}
	
	private void validateCreateCompany(Company company) throws ApplicationException {
		if(companyDao.isCompanyExistByName(company.getCompany_name())) {	
			throw new ApplicationException(ErrorType.ALREADY_EXISTS,DateUtils.getCurrentDateAndTime() + " Failed to create Company - name already exists");	
		}
		if (!DataValidationUtils.validateEmail(company.getEmail())) {
			throw new ApplicationException(ErrorType.WRONG_INPUT,DateUtils.getCurrentDateAndTime() + " Failed to create Company - invalid email");	
		}
		if(!(company.getPassword().length() > 0) && company.getPassword().length() < 200) {
			throw new ApplicationException(ErrorType.WRONG_INPUT,DateUtils.getCurrentDateAndTime() + " Failed to create Company - illegal password");
		}
	}

	//Updating Company
	public void updateCompany(Company company)throws ApplicationException  {
		validateUpdateCompany(company);
		companyDao.updateCompany(company);
	}
private void validateUpdateCompany(Company company) throws ApplicationException {
	if(companyDao.isCompanyExistByName(company.getCompany_name())) {	
		throw new ApplicationException(ErrorType.ALREADY_EXISTS,DateUtils.getCurrentDateAndTime() + " Failed to update Company - name already exists");	
	}
	if (!DataValidationUtils.validateEmail(company.getEmail())) {
		throw new ApplicationException(ErrorType.WRONG_INPUT,DateUtils.getCurrentDateAndTime() + " Failed to update Company - invalid email");	
	}
	if(!(company.getPassword().length() > 0) && company.getPassword().length() < 200) {
		throw new ApplicationException(ErrorType.WRONG_INPUT,DateUtils.getCurrentDateAndTime() + " Failed to update Company - illegal password");
	}
}

	//Removing Company
	public void removeCompany(long companyID) throws ApplicationException {
		if(!companyDao.isCompanyExistsByCompanyID(companyID)) {
			throw new ApplicationException(ErrorType.GENERAL_ERROR,DateUtils.getCurrentDateAndTime() + "Failed to remove Company");
		}
		companyDao.removeCompany(companyID);
	}

	

	//Getting a collection of all Companies
	public Collection<Company> getAllCompanies() throws ApplicationException {
		return companyDao.getAllCompanies();

	}



	//Getting Company by ID
	public Company getCompanyByCompanyID (long companyID) throws ApplicationException {

		if(!companyDao.isCompanyExistsByCompanyID(companyID)) {			
			throw new ApplicationException(ErrorType.GENERAL_ERROR,DateUtils.getCurrentDateAndTime() + "Failed to find Company by ID");
		}
		return companyDao.getCompanyByCompanyID(companyID);

	}

	
}
