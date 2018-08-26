package com.avikdeb.java.util;

public class CustomDateTimeFormatter {
	
	private String inputDatetime;
	private String formattedDate;
	private String formattedTime;
	
	public CustomDateTimeFormatter() {
		
	}
	
	public String getFormattedDate(String inputDatetime) {
		
		this.inputDatetime = inputDatetime;
		int index = inputDatetime.indexOf("T"); // The format passed being:
		formattedDate = inputDatetime.substring(0, index);
		
		return formattedDate;
		
	}
	
	public String getFormattedTime(String inputDatetime) {
		
		this.inputDatetime = inputDatetime;
		int index = inputDatetime.indexOf("T");
		formattedTime = inputDatetime.substring(index+1, index+9);
		
		return formattedTime;
	}

}
