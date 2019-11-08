package com.dani.coupons.Tester;

import com.dani.coupons.Enums.CouponType;
import com.dani.coupons.beans.Company;
import com.dani.coupons.beans.Coupon;
import com.dani.coupons.beans.Customer;
import com.dani.coupons.logic.CompanyService;
import com.dani.coupons.logic.CouponService;
import com.dani.coupons.logic.CustomerService;
import com.dani.coupons.threads.RemoveOldCouponTimeTask;



import java.sql.Connection;
import java.util.Collection;
public class Tester {
	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
	//	Coupon coupon = new Coupon("NIKE", 3, 99.8976, "2011-10-10", "2012-10-10", "HELLO", "GOOD", CouponType.Restaraunt);
		//CouponUnitTester tester = new CouponUnitTester();
		//long id = tester.createCoupon(coupon);
		//tester.removeCoupon(id);
		//tester.getCoupon(id);
	CustomerService test = new CustomerService();
	CouponService cTest = new CouponService();
	CompanyService xTest = new CompanyService();
		//CompanyController companyController=new CompanyController(); 
//	Company company = new Company(1,"Roladin","roladin1@gmail.com","666789");
//	xTest.createCompany(company);
	
	
	//Company company = new Company("BooIntenational","boo1@gamil.com","9876");
	//xTest.createCompany(company);
	
//	Company company2 = new Company("ADIDAS","adidas7@gamil.com","1010");
//	xTest.createCompany(company2);
//	Company company3 = new Company("Columbia","col2@walla.com","7897");
//	xTest.createCompany(company3);
	//Coupon coupon = new Coupon("Title",10,79.gedg99,);
	//companyController.getCompanyByCompanyID(1);
Coupon coupon = new Coupon("CASTRO", 72, 299.99, "2017-10-10", "2019-10-10", "REAL", "CLOTHES", CouponType.Restaraunt,165);
//cTest.createCoupon(coupon);
	//xTest.removeCompany(2);
//	xTest.removeCompany(3);
//	xTest.removeCompany(4);
//	xTest.removeCompany(5);
//	xTest.removeCompany(6);
//	xTest.removeCompany(7);
//	xTest.removeCompany(8);
//	xTest.removeCompany(9);
//	xTest.removeCompany(10);
//	xTest.removeCompany(11);
//	xTest.removeCompany(12);
//	xTest.removeCompany(13);
//	xTest.removeCompany(14);
//	xTest.removeCompany(15);
	
	
	
	//CustomerController customerController=new CustomerController();
	//RemoveOldCouponTimeTask thread = new RemoveOldCouponTimeTask();
//	Customer  customer9 = new Customer("Daneille","hayke301@gmail.com","12345678900");
//	Customer customer1 = new Customer("Gerrard","steven31@gmail.com","1234");
//	Customer customer2 = new Customer("Lampard","lamps32@gmail.com","1234");
//	Customer customer3 = new Customer("jack", "danijackychan33@gmail.com","1234");
//	Customer customer14 = new Customer("Drogba", "didi11@gmail.com","1111111");
	//Coupon coupon = new Coupon("NIKE", 3, 99.8976, "2011-10-10", "2012-10-10", "HELLO", "GOOD", CouponType.Restaraunt);
	//cTest.createCoupon(coupon);
	//customerController.createCustomer(customer9);

	//customerController.getAllCustomers();
	
	
	
	//test.createCustomer(customer);
	//test.createCustomer(customer1);
	//test.createCustomer(customer2);
	//test.createCustomer(customer3);
	//Collection<Coupon> coupons =cTest.getAllPutchasedCoupons(0);
	//System.out.println(coupons);
		//Customer customer=new Customer(13,"Anna Artym", "artdym");
		
	
		//customerController.createCustomer(customer);
      
	
	//customerController.removeCustomerByCustomerID(15);

//		//Customer customer9=customerController.getCustomerByCustomerID(9);
//		//System.out.println(customer9.toString());
//		//Collection<Customer> allCustomers=customerController.getAllCustomers();
//		//System.out.println(allCustomers.toString());
//		//System.out.println("Customer login is successful? "+ customerController.login("Noa Cohen", "noa221", ClientType.CUSTOMER));
//		Company company=new Company("Best Tour", "flyfgf", "bestTours@gmail.co.il");
//		CompanyController companyController=new CompanyController();
		
//		//companyController.removeCompanyByCompanyID(17);
//		//companyController.UpdateCompany(company); 
//		//Company company12=companyController.getCompanyByCompanyID(12);
//		//System.out.println(company12.toString());
//		//Collection<Company> allCompanies=companyController.getAllCompanies();
//		//System.out.println(allCompanies.toString());
//		//System.out.println("Company login is successful? "+ companyController.login("Messa", "BestRestt", ClientType.COMPANY));
//		Coupon coupon=new Coupon( "Happy New Year with Mes","2017/12/30", "2018/11/27", 1, CouponType.RESTURANS,
//				"Celebrate new year with your best friend in the best chef restaruant", 200, "Messa.png", 12);
//		CouponController couponController=new CouponController();
////		couponController.createCoupon(coupon);
	}
}
