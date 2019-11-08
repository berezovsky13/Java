package com.dani.coupons.threads;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.TimerTask;

import com.dani.coupons.beans.Coupon;
import com.dani.coupons.dao.CouponDao;

public class RemoveOldCouponTimeTask extends TimerTask {

	
	
	private static int SECONDS_IN_A_DAY = 24 * 60 * 60 * 1000; 
	
	private  CouponDao couponDao;
	
	public RemoveOldCouponTimeTask() {
		this.couponDao = new CouponDao();
	}
	
	@Override
	public void run() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDateTime now = LocalDateTime.now();
		couponDao.removeOldCoupon(dtf.format(now));
		System.out.println("Coupon has been removed");
		
		
	}
	public void startTask() {
		RemoveOldCouponTimeTask task = new RemoveOldCouponTimeTask();
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(task, 0, SECONDS_IN_A_DAY);
	}
	
	
	
	

	
	
	
}
