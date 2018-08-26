package com.avikdeb.java.util;

public class ConfigFormatter {

	private String osName = "";
	
	public ConfigFormatter() {
		
	}
	
	public String getOsType() {
		
		HostOSChecker osChecker = HostOSChecker.getInstance();
		String os = osChecker.getOsName();
		if(os.contains("Windows")) {
			osName = "Windows";
		}
		else {
			osName = "Non-windows";
		}
		
		return osName;
		
	}

}
