package com.dani.coupons.logic;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.dani.coupons.Enums.CouponType;
import com.dani.coupons.Enums.ErrorType;
import com.dani.coupons.beans.Company;
import com.dani.coupons.beans.Coupon;
import com.dani.coupons.dao.CompanyDao;
import com.dani.coupons.dao.CompanyDaoJPA;
import com.dani.coupons.dao.CouponDao;
import com.dani.coupons.dao.CouponDaoJPA;
import com.dani.coupons.dao.CustomerDao;
import com.dani.coupons.entities.CouponEntity;
import com.dani.coupons.exceptions.ApplicationException;
import com.dani.coupons.utilities.DateUtils;

@Controller
public class CouponController {

//	@Autowired
//	private CouponDao couponDao;
//	@Autowired
//	private CompanyDao companyDao;
//	@Autowired
//	private CustomerDao customerDao;

	@Autowired
	private CouponDaoJPA couponDaoJpa;
	
//	public CouponController(){
//		this.couponDao=new CouponDao();
//		this.companyDao=new CompanyDao();
//		this.customerDao=new CustomerDao();
//	}
	//Creating a new Coupon
	public void createCoupon(CouponEntity coupon)  throws ApplicationException {
		validateCreateCoupon(coupon);
		couponDaoJpa.createCoupon(coupon);
	}
	private void validateCreateCoupon(CouponEntity coupon) throws ApplicationException{
	if(!(coupon.getPrice()<=500)) {
		throw new ApplicationException(ErrorType.DB_ERROR,DateUtils.getCurrentDateAndTime() 
				+ "You cannot buy coupons in price that is higher than 500$");
	}
		
	if(!(coupon.getTitle().length()>0)&&coupon.getTitle().length()<100) {
		throw new ApplicationException(ErrorType.WRONG_INPUT,DateUtils.getCurrentDateAndTime() + "Title already exists or Invalid title input policy");
	}
	
		
	if (coupon.getAmount()<=0) {
	throw new ApplicationException(ErrorType.INVALID_AMOUNT, DateUtils.getCurrentDateAndTime()
    +" Create coupon has failed or the user wanted to create a new coupon but inserted invalid amount");
					
		}
	
	
	
	}
	//Updating Coupon
	public void updateCoupon(CouponEntity coupon) throws ApplicationException {
		
		validateUpdateCoupon(coupon);
		couponDaoJpa.updateCoupon(coupon);
       	
	}

  
    	private void validateUpdateCoupon(CouponEntity coupon) throws ApplicationException{
    		if(!(coupon.getPrice()<=500)) {
    			throw new ApplicationException(ErrorType.DB_ERROR,DateUtils.getCurrentDateAndTime() 
    			+ "Failed to update coupon with this  price becaues it is higher than 500$");
    		}
    			
    		if(!(coupon.getTitle().length()>0)&&coupon.getTitle().length()<100) {
    			throw new ApplicationException(ErrorType.WRONG_INPUT,DateUtils.getCurrentDateAndTime() + "Failed to update coupon because of illegal title lenght");
    		}
    		
    			
    		if (coupon.getAmount()<=0) {
    		throw new ApplicationException(ErrorType.INVALID_AMOUNT, DateUtils.getCurrentDateAndTime()
    	    +" Update coupon has failed because of inserted invalid amount");
    						
    			}
    		String datePattern="^\\d{4}/{1}\\d{2}/{1}\\d{2}";
    		if (!coupon.getStartDate().matches(datePattern)||!coupon.getEndDate().matches(datePattern)) {
    		throw new ApplicationException(ErrorType.WRONG_INPUT, DateUtils.getCurrentDateAndTime()+" Update coupon has failed because of wrong start date input and end date");
    		}
    	
    	
    	
    }
	
    	public void removeCoupon(long id) throws ApplicationException {
    		
    
    				this.couponDaoJpa.removeCoupon(id);
    			}

    			
    	public Collection<CouponEntity> getAllcoupons() throws ApplicationException {
		return couponDaoJpa.getAllCoupons();
	}
    	
    	
    	
    	public CouponEntity getCouponById (long id) throws ApplicationException {

    		return couponDaoJpa.getCouponById(id);
    	}
    	
    	
    	
	//Removing Coupon
//	public void removeCoupon(long couponID) throws ApplicationException {
//
//		validateRemoveCoupon(couponID);
//		this.couponDao.removeCoupon(couponID);
//	}

//	private void validateRemoveCoupon(long couponID) throws ApplicationException{
//		
//		if(!this.couponDao.isCouponExists(couponID)) {
//		throw new ApplicationException(ErrorType.GENERAL_ERROR,DateUtils.getCurrentDateAndTime() + " Failed to remove Coupon by it's ID / Wrong ID inserted ");
//		}	
//	}
	
	//Purchasing an existing Coupon
	//public void purchaseCoupon(long customerID, long couponID) throws ApplicationException{
		//We validate a purchase of a coupon
	//	validatePurchaseCoupon(customerID, couponID); 

		//If we didn't catch any exception, we call the 'purchaseCoupon' method.
		//this.couponDao.purchaseCoupon(customerID, couponID);
	//}

//	private void validatePurchaseCoupon(long customerID, long couponID) throws ApplicationException{
//		//We check if the customerID provided is valid
//		if (!this.customerDao.isCustomerExistByID(customerID)) {
//			throw new ApplicationException(ErrorType.WRONG_INPUT, DateUtils.getCurrentDateAndTime()
//					+" Purchase Coupon has failed because of imvalid customerID");
//					
//		}

		//We check if the couponID provided is valid
//		if (!this.couponDao.isCouponExists(couponID)) {
//			throw new ApplicationException(ErrorType.WRONG_INPUT, DateUtils.getCurrentDateAndTime()
//					+" Purchase Coupon has failed because of invalid couponID");
//					
//		}
	

	
	
//	public Coupon getCouponByCouponID (long couponID) throws ApplicationException {
//
//		if(!couponDao.isCouponExists(couponID)) {			
//			throw new ApplicationException(ErrorType.GENERAL_ERROR,DateUtils.getCurrentDateAndTime() + "Failed to find Coupon by ID");
//		}
//		return couponDao.getCouponByCouponID(couponID);
//
//	}
	
	
	
	
	
	
}

