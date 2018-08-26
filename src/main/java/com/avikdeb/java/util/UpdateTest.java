package com.avikdeb.java.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UpdateTest {
	
	public static void main(String[] args) {
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date today = new Date();
		String currentDate = dateFormat.format(today);
		System.out.println("Today - "+currentDate);
		
		Date past = null;
		String pastDate = "2017-08-01 09:00:00";
		try {
			past = dateFormat.parse(pastDate);
			System.out.println("Past date - "+pastDate);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		long diff = today.getTime() - past.getTime();
		long diffHours = diff / (60*60*1000);
		System.out.println("Hour Difference = "+diffHours);
		
		if(diffHours>2) {
			System.out.println("Send update");
		} else {
			System.out.println("Do nothing");
		}
		

	}

}
