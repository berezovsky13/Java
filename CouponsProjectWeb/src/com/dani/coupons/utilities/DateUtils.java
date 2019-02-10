package com.dani.coupons.utilities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {
	
	public static String getCurrentDateAndTime() {
		DateTimeFormatter dtf = dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		return dtf.format(now);
	}

	
		
		
 		
	
}
