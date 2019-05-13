package com.dani.coupons.dao;

import java.util.Collection;

import com.dani.coupons.beans.Company;
import com.dani.coupons.exceptions.ApplicationException;

public interface ICompanyDao {
public void createCompany(Company company) throws ApplicationException ;
	
	public void updateCompany(Company company)  throws ApplicationException;
	
	public void removeCompany(long companyID)  throws ApplicationException;

	public Collection<Company> getAllCompanies()  throws ApplicationException;
	
	public boolean login(String email, String password)  throws ApplicationException;
	
	public boolean isCompanyExistByName(String companyName)  throws ApplicationException;
	
	boolean isCompanyExistsByCompanyID(long companyID) throws ApplicationException;

	
	
}
