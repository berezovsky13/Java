package com.dani.coupons.utilities;
//package com.dani.coupons.utilities;
//
//import com.dani.coupons.Enums.ClientType;
//import com.dani.coupons.beans.UserLoginDetails;
//import com.dani.coupons.dao.CompanyDao;
//import com.dani.coupons.dao.CustomerDao;
//import com.dani.coupons.exceptions.ApplicationException;
//
//public class LoginUtils {
//	public static boolean login(UserLoginDetails userLoginDetails) throws ApplicationException{
//		ClientType clientType=userLoginDetails.getType();
//		String name=userLoginDetails.getUserName();
//		String password=userLoginDetails.getPassword();
//		if (clientType==ClientType.ADMIN) {
//			return(name.equals("admin")&&password.equals("1234"));
//		}	
//		else if (clientType==ClientType.CUSTOMER) {
//			//We create a CustomerDao object, in order to have access to the 'login' method-
//			//Comparing the input provided with the DB registrations.
//			CustomerDao customerDao=new CustomerDao();
//			return (customerDao.login(name, password)); 
//		}
//		else {
//			//We create a CompanyDao object, in order to have access to the 'login' method-
//			//Comparing the input provided with the DB registrations.
//			CompanyDao companyDao=new CompanyDao();
//			return (companyDao.login(name, password)); 
//		}
//	}
//}
