package com.dani.coupons.api;


import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

//import javax.websocket.server.PathParam;
//import javax.ws.rs.Consumes;
//import javax.ws.rs.DELETE;
//import javax.ws.rs.GET;
//import javax.ws.rs.POST;
//import javax.ws.rs.PUT;
//import javax.ws.rs.Path;
//import javax.ws.rs.PathParam;
//import javax.ws.rs.Produces;
//import javax.ws.rs.QueryParam;
//import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dani.coupons.Enums.CouponType;
import com.dani.coupons.beans.Company;
import com.dani.coupons.beans.Coupon;
import com.dani.coupons.beans.Customer;
import com.dani.coupons.entities.CouponEntity;
import com.dani.coupons.exceptions.ApplicationException;
import com.dani.coupons.logic.CompanyService;
import com.dani.coupons.logic.CouponService;

//@Produces(MediaType.APPLICATION_JSON)
//@Consumes(MediaType.APPLICATION_JSON)


@RestController
@RequestMapping(value="/coupons")
public class CouponApi {

	@Autowired
	private CouponService couponService;
	

	public CouponApi () {
		this.couponService = new CouponService();
	}
	
	

	
		

	
	@PostMapping
	public void createCoupon (@RequestBody Coupon coupon) throws ApplicationException {

		couponService.createCoupon(coupon);
	}

	

	@DeleteMapping("/{id}")
	public void removeCoupon (@PathVariable long id) throws ApplicationException {

		couponService.removeCoupon(id);
	}
	
	


	@PutMapping
	public void updateCoupon (@RequestBody Coupon coupon) throws ApplicationException {

		couponService.updateCoupon(coupon);
	}
	
	
	
	
	
	
	
	
	@GetMapping("/all")
	public Collection <Coupon> getAllCoupons () throws ApplicationException {

		return this.couponService.getAllcoupons();
	}
	
	
	
	

	
	
}
	
	
	
