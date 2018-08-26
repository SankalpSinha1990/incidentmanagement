package com.avikdeb.java.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class JiraResultFileFormatter {
	
	private static String filename = "";
	private static String lineToRemove = "";
	private static File srcFile;
	
	public JiraResultFileFormatter() {
		
	}
	
	public static void removeHeader(String filename, int startline, int numline) {
	
		try {
			
			BufferedReader br = new BufferedReader(new FileReader(filename));
			StringBuffer sb = new StringBuffer();
			int linenumber = 1;
			String line;
			
			while((line=br.readLine())!=null){
				
				if(linenumber<startline || linenumber>=startline+numline)
					sb.append(line+"\n");
				linenumber++;
			}
			
			if(startline+numline>linenumber)
				System.out.println("EOF reached");
			br.close();
			
			FileWriter fw = new FileWriter(new File(filename));
			fw.write(sb.toString());
			fw.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		JiraResultFileFormatter formatter = new JiraResultFileFormatter();
		String filename = "";
		HostOSChecker os = HostOSChecker.getInstance();
		if(os.getOsName().equalsIgnoreCase("windows 7")) {
			filename = "C:\\incident_home\\jira_jql.json";
		} else {
			filename = "user/home/incident_home/jira_jql.json";
		}
		int startline = 1;
		int numline = 16;
		
		formatter.removeHeader(filename, startline, numline);
	}

}
