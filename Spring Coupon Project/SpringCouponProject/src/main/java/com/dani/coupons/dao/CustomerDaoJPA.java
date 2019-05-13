package com.dani.coupons.dao;


import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dani.coupons.entities.CompanyEntity;
import com.dani.coupons.entities.CouponEntity;
import com.dani.coupons.entities.CustomerEntity;
import com.dani.coupons.exceptions.ApplicationException;




@Repository
public class CustomerDaoJPA {

	
	@PersistenceContext(unitName="coupon__project")
	private EntityManager entityManager;
	
	public CustomerDaoJPA() {
		System.out.println("CustomerJPA has been created");
	}
	
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void createCustomer(CustomerEntity customer) {
		
		entityManager.persist(customer);
			
		
	}

	
	@Transactional(propagation=Propagation.REQUIRED)
	public void updateCustomer(CustomerEntity customer) throws ApplicationException{
	entityManager.merge(customer);
	
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public void removeCustomer(long id) throws ApplicationException{
		entityManager.remove(id);
	}
	
	
	public boolean isCustomerExistById(long id) throws ApplicationException {
		CustomerEntity ce = entityManager.find(CustomerEntity.class, id);
		if (ce != null) {
			return true;
		}
		return false;
	}
	
	
	@Transactional(propagation=Propagation.REQUIRED)
	public CustomerEntity getCustomerById (long userId) throws ApplicationException {

		Query query = entityManager.createQuery("FROM CustomerEntity customer WHERE customer.userLoginDetails.id=:id").setParameter("id", userId);

		CustomerEntity customer; 

		Collection results = query.getResultList();

		if(results.isEmpty()) {
			customer = null;
		} else {
			customer = (CustomerEntity) query.getSingleResult();
		}

		return customer;
	}
	
	
	
	
	
	@Transactional(propagation = Propagation.REQUIRED)
	public Collection<CustomerEntity> getAllCustomers() throws ApplicationException {
		String hql = "FROM CustomerEntity";
		Query query = entityManager.createQuery(hql);
		@SuppressWarnings("unchecked")
		Collection<CustomerEntity> customers = query.getResultList();
		return customers;
	}
	
	
	
	
	
	@PostConstruct
	public void afterBeanCreated() {
		System.out.println("");
	}
	
	
}
