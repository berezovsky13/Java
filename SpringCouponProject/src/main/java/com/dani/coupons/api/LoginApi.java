package com.dani.coupons.api;


//	import java.io.IOException;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//	import javax.ws.rs.POST;
//	import javax.ws.rs.Path;
//	import javax.ws.rs.core.Context;
//	import javax.ws.rs.core.MediaType;
//	import javax.ws.rs.core.Response;
//	import com.dani.coupons.dao.CompanyDao;
//	import com.dani.coupons.dao.CustomerDao;
//	import com.dani.coupons.Enums.ClientType;
//import com.dani.coupons.beans.UserLoginDetails;
//import com.dani.coupons.exceptions.ApplicationException;
//
//	
//		@Path("/login")
//		public class LoginApi {						
//			//Checks if the username and password match the information in DB if yes return true 
//			@POST
//			@Path("/Userlogin")
//			public void login(@Context HttpServletRequest request,
//					@Context HttpServletResponse response,
//					UserLoginDetails loginData) throws IOException, ApplicationException, ServletException
//			{
//				System.out.println("Name:"+loginData.getUser()+" Pass:"+loginData.getPassword());
//
//				System.out.println("into login");
//				if(loginData.getUser().equals("Admin") && loginData.getPassword().equals("1234")) {
//					System.out.println("Succses");		
//
//					request.getSession();
//					Cookie cookie=new Cookie("user",loginData.getUser());
//					cookie.setPath("/");
//					response.addCookie(cookie);
//					System.out.println(response.getStatus());
//				}
//				else {
//					response.setStatus(401);
//					response.getStatus();
//					System.out.println(response.getStatus());
//					throw new ApplicationException(null, String.valueOf(response.getStatus()));
//					
//					//response.setStatus(401);
//					//response.getStatus();
//					//System.out.println(response.getStatus());
//
//				}		
//			}
//		}