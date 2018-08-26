package com.avikdeb.java.util;

public class HostOSChecker {

	private static String osName = "";
	
	private HostOSChecker() {
		
	}
	
	public static HostOSChecker getInstance() {
		
		HostOSChecker osChecker = new HostOSChecker();
		return osChecker;
		
	}
	
	public static String getOsName() {
		
		osName = System.getProperty("os.name");
		return osName;
	}

}
