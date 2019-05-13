package com.dani.coupons.dao;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import com.dani.coupons.beans.Company;
import com.dani.coupons.entities.CompanyEntity;
import com.dani.coupons.exceptions.ApplicationException;



@Repository
public class CompanyDaoJPA {

	@PersistenceContext(unitName="coupon__project")
	private EntityManager entityManager;
	
	public CompanyDaoJPA() {
		System.out.println("CompanyDaoJPA has been created");	
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void createCompany(CompanyEntity company){
		entityManager.persist(company);
		
		CompanyEntity company2 = new CompanyEntity("Yossi", "3333334", "sagi1@gmail.com");
		CompanyEntity company3 = new CompanyEntity("Danny", "55555555","hagi2@gmail.com");
		
		entityManager.persist(company2);
		entityManager.persist(company3);
		
		company2.setFather(company2);
		company3.setFather(company3);
		
		return;
	}
	
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void updateCompany(CompanyEntity company){
	entityManager.merge(company);
	
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void removeCompany(long companyID) {
		entityManager.remove(companyID);
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public Collection<CompanyEntity> getAllCompanies()  {
		String hql = "FROM CompanyEntity";
		Query query = entityManager.createQuery(hql);
		@SuppressWarnings("unchecked")
		Collection<CompanyEntity> companies = query.getResultList();
		return companies;
	}
	
	public boolean isCompanyExist(long id) throws ApplicationException {
		CompanyEntity ce = entityManager.find(CompanyEntity.class, id);
		if (ce != null) {
			return true;
		}
		return false;
	}
	@Transactional(propagation=Propagation.REQUIRED)
	public CompanyEntity getByIdCompany(long id) throws ApplicationException {
		
		CompanyEntity company = entityManager.find(CompanyEntity.class, id);
		
		return company;
	}
	
	
	
	
	
}
