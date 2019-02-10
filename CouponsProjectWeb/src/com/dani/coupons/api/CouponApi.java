package com.dani.coupons.api;


import java.util.Collection;

//import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.dani.coupons.Enums.CouponType;
import com.dani.coupons.beans.Company;
import com.dani.coupons.beans.Coupon;
import com.dani.coupons.beans.Customer;
import com.dani.coupons.exceptions.ApplicationException;
import com.dani.coupons.logic.CompanyController;
import com.dani.coupons.logic.CouponController;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)


@Path("/coupons")
public class CouponApi {
private CouponController couponController;
	

	public CouponApi () {
		this.couponController = new CouponController();
	}
	
	
	@GET
	@Path("/customerName")
	public void getUserByName(@QueryParam("coupon_name") String name){
		System.out.println(name);
	}
		
	
		
	@POST
	public void createCoupon(Coupon coupon)throws ApplicationException{
		this.couponController.createCoupon(coupon);
	
}
	@PUT
	public void updateCoupon(Coupon coupon) throws ApplicationException {
		couponController.updateCoupon(coupon);
	}

	@DELETE
	@Path("/{couponID}")
	 public void removeCoupon(@PathParam("couponID") long couponID) throws ApplicationException{
	this.couponController.removeCoupon(couponID);
	}
	
	@GET
	@Path("/all")
	public Collection<Coupon> getAllCoupons() throws ApplicationException{
		return this.couponController.getAllcoupons();
	}
	@GET
	
	
	@Path("/allPurchased")
	public Collection<Coupon> getAllPurchaserCoupons() throws ApplicationException{
		return this.couponController.getAllPurchasedCoupons();
	}


	@GET
	@Path("/{couponID}")
	public void getCouponByCouponID(@PathParam("couponID") long couponID) throws ApplicationException{
		couponController.getCouponByCouponID(couponID);
	}
	
	
}
	
	
	
