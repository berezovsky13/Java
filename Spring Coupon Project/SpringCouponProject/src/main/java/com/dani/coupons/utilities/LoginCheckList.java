package com.dani.coupons.utilities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginCheckList {

	private final static String EMAIL_REGEX = "[A-Z0-9_%+-]+@[A-Z0-9.-]+\\.[A-Z] {2,6}$";
	private final static String PASSWORD_REGEX = "[A-Z0-9_%+-]+@[A-Z] {2,6}$";
	private final static String NAME_REGEX = "[a-zA-z , '] {2,}";
		
		public static boolean isPasswordValid(String password){
			if(password.matches(PASSWORD_REGEX)) {
				return true;
			}
			
			boolean characterPassword = false;
			
			
			
			if( password.matches(EMAIL_REGEX)) {
				characterPassword = true;
			}
			if(characterPassword) {
				System.out.println("Password is valid");
				return true;
			}
			System.out.println("Password is invalid");
			return false;
			
			
		}
		public static boolean isEmailValid(String email) {
			Pattern emailPattern = Pattern.compile(EMAIL_REGEX);
			
			Matcher matcher = emailPattern.matcher(email);
			
			return matcher.find();
		}
		
		public static boolean isNameValid (String name) {
			if(name.matches(NAME_REGEX)) {
				return true;
			}
			
			return false;
		}
	
}
