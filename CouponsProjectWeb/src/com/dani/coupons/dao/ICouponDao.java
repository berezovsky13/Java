package com.dani.coupons.dao;

import java.util.Collection;
import java.util.List;
import com.dani.coupons.Enums.CouponType;
import com.dani.coupons.beans.Coupon;
import com.dani.coupons.exceptions.ApplicationException;

public interface ICouponDao {

	
    public void createCoupon (Coupon coupon) throws ApplicationException ;
	
	public void updateCoupon (Coupon coupon) throws ApplicationException;
	
	public void removeCoupon (long couponID)throws ApplicationException;
	 
	public Collection<Coupon> getAllCouponsByType (CouponType type)throws ApplicationException;
	
	public Collection<Coupon> getAllCoupons()throws ApplicationException;
	
	public Collection<Coupon> getAllPurchasedCouponsByType(CouponType type)throws ApplicationException;
	
	public boolean isCouponExists(long couponID)  throws ApplicationException;
	
	public Collection<Coupon> getAllPurchasedCoupons()throws ApplicationException;
	
	public Coupon getCouponByCouponID(long couponID) throws ApplicationException;

	boolean isCouponExistsByTitle(String title) throws ApplicationException;

	public void purchaseCoupon(long couponID, long customerID) throws ApplicationException;

	
}

