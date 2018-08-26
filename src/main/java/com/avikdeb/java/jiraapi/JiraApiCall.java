package com.avikdeb.java.jiraapi;

import java.sql.BatchUpdateException;

import com.avikdeb.java.util.HostOSChecker;
import com.avikdeb.java.util.JiraResultFileFormatter;

public class JiraApiCall {
	
	//private static String batfilepath = "D:\\javalab2\\javalab\\src\\com\\avikdeb\\java\\resources\\jira_curl.bat";
	private static String batfilepath = "";
	private static String command;
	
	public JiraApiCall() {
		
	}
	
	//Calls the bat file to run the Jira API call using curl
	public static void callJiraCurl() {
		
		HostOSChecker os = HostOSChecker.getInstance();
		System.out.println(os.getOsName());
		if(os.getOsName().equalsIgnoreCase("windows 7")) {
			batfilepath = "C:\\incident_home\\jira_curl.bat";
			System.out.println(batfilepath);
		} else {
			batfilepath = "user/home/incident_home/jira_curl.sh";
		}
		
		command = "cmd /c start "+batfilepath;
		Runtime runtime = Runtime.getRuntime();
		try {
			
			runtime.exec(command);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	//Calls the bat file to run the Jira API call using curl
	public static void main(String[] args) {
			
		callJiraCurl();
		
	}
	
}
