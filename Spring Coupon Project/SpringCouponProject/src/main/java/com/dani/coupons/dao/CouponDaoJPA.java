package com.dani.coupons.dao;

import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dani.coupons.beans.Company;
import com.dani.coupons.entities.CompanyEntity;
import com.dani.coupons.entities.CouponEntity;
import com.dani.coupons.exceptions.ApplicationException;

@Repository
public class CouponDaoJPA {

	
	@PersistenceContext(unitName="coupon__project")
	private EntityManager entityManager;
	
	public CouponDaoJPA() {
		System.out.println("CouponJPA has been created");
	}
	
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void createCoupon(CouponEntity coupon) {
		
		entityManager.persist(coupon);
		
		CouponEntity coupon2 = new CouponEntity(99, "FC Barcelona", 12, 19, "Football team","2018.12.12" ,"2019.12.12" );
		CouponEntity coupon3 = new CouponEntity(100,"Renuar",14,22,"Winter collection","2018.12.12","2019.12.12");
		
		entityManager.persist(coupon2);
		entityManager.persist(coupon3);
		
		
		
	}

	
	@Transactional(propagation=Propagation.REQUIRED)
	public void updateCoupon(CouponEntity coupon) throws ApplicationException{
	entityManager.merge(coupon);
	
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public void removeCoupon(long id) throws ApplicationException{
		entityManager.remove(id);
	}
	
	
	public boolean isCouponExist(long id) throws ApplicationException {
		CouponEntity ce = entityManager.find(CouponEntity.class, id);
		if (ce != null) {
			return true;
		}
		return false;
	}
	
	
	@Transactional(propagation=Propagation.REQUIRED)
	public CouponEntity getCouponById(long id) throws ApplicationException {
		
		CouponEntity coupon = entityManager.find(CouponEntity.class, id);
		
		return coupon;
	}
	
	
	
	
	
	@Transactional(propagation = Propagation.REQUIRED)
	public Collection<CouponEntity> getAllCoupons() throws ApplicationException {
		String hql = "FROM CouponEntity";
		Query query = entityManager.createQuery(hql);
		@SuppressWarnings("unchecked")
		Collection<CouponEntity> coupons = query.getResultList();
		return coupons;
	}
	
	
	
	
	
	@PostConstruct
	public void afterBeanCreated() {
		System.out.println("");
	}
	






}
