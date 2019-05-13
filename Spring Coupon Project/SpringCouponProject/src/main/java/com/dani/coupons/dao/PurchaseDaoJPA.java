package com.dani.coupons.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dani.coupons.entities.PurchaseEntity;
import com.dani.coupons.exceptions.ApplicationException;



@Repository
public class PurchaseDaoJPA {

	@PersistenceContext(unitName="CouponSpringUnit")
	private EntityManager entityManager;



	@Transactional(propagation=Propagation.REQUIRED)
	public long createPurchase (PurchaseEntity purchase) throws ApplicationException {

		entityManager.persist(purchase);

		return purchase.getId();
	}



	@Transactional(propagation=Propagation.REQUIRED)
	public void updatePurchase(PurchaseEntity purchase) {

		entityManager.merge(purchase);
	}

	

	@Transactional(propagation=Propagation.REQUIRED)
	public void removePurchase (long id) throws ApplicationException{

		PurchaseEntity purchase = entityManager.find(PurchaseEntity.class, id);

		entityManager.remove(purchase);
	}


	// If the purchase doesn't exist, returns null
	@Transactional(propagation=Propagation.REQUIRED)
	public PurchaseEntity getPurchase(long id) throws ApplicationException {

		PurchaseEntity purchase = entityManager.find(PurchaseEntity.class, id);

		return purchase;
	}

	// If the purchase doesn't exist, returns null
	@Transactional(propagation=Propagation.REQUIRED)
	public PurchaseEntity getPurchase(long customerId, long couponId) throws ApplicationException {

		Query query = entityManager.createQuery("FROM PurchaseEntity purchase WHERE purchase.customer.userLoginDetails.id=:customerId AND purchase.coupon.id=:couponId")
				.setParameter("customerId", customerId).setParameter("couponId", couponId);

		PurchaseEntity purchase;

		List results = query.getResultList();

		if(results.isEmpty()) {
			purchase = null;
		} else {
			purchase = (PurchaseEntity) query.getSingleResult();
		}

		return purchase;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public List<PurchaseEntity> getCustomerPurchases (long customerId) throws ApplicationException {

		Query query = entityManager.createQuery("FROM PurchaseEntity purchase WHERE purchase.customer.userLoginDetails.id=:customerId").setParameter("customerId", customerId);

		@SuppressWarnings("unchecked")
		List<PurchaseEntity> allPurchases = query.getResultList();

		return allPurchases;
	}
}
