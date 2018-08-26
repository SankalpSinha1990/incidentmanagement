package com.avikdeb.java.util;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.avikdeb.java.beans.JiraIssue;


public class JiraDataParser {
	
	//private static String filepath = "D:\\javalab2\\javalab\\src\\com\\avikdeb\\java\\resources\\jira_jql.json";
	private static String filepath = "";
	
	public ArrayList<JiraIssue> getJiraIssueList() {
		
		ConfigFormatter cf = new ConfigFormatter();
		String os = cf.getOsType();
		
		if(os.equalsIgnoreCase("windows")) {
			//Call windows path
			filepath = "C:\\incident_home\\jira_jql.json";
		} else if(os.equalsIgnoreCase("windows")) {
			//Call unix path
			filepath = "/usr/home/incident_home/jira_jql.json";
		}
		
		ArrayList<JiraIssue> jiraissuelist = new ArrayList<JiraIssue>();
		
		try {
			
			//Read the JSON file
			FileReader reader = new FileReader(filepath);
			
			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
			
			//Get the arrays
			JSONArray issues = (JSONArray) jsonObject.get("issues");
			
			//Getting the required information from the objects in array
			Iterator i = issues.iterator();
			
			while(i.hasNext()) {
				
				JiraIssue jira = new JiraIssue();
				
				JSONObject innerObject = (JSONObject) i.next();
				String jiraid = innerObject.get("key").toString();
				System.out.println("JIRA ID (Key): "+jiraid);
				jira.setJiraid(jiraid);
				
				JSONObject fields = (JSONObject)innerObject.get("fields");
				String summary = fields.get("summary").toString();
				System.out.println("Summary: "+summary);
				jira.setSummary(summary);
				
				String created = fields.get("created").toString();
				System.out.println("Created: "+created);
				jira.setCreatedon(created);
				
				JSONObject priority = (JSONObject)fields.get("priority");
				String priorityname = priority.get("name").toString();
				System.out.println("Priority: "+priorityname);
				jira.setPriority(priorityname);
				
				JSONObject status = (JSONObject)fields.get("status");
				String statusname = status.get("name").toString();
				System.out.println("Status: "+statusname);
				jira.setStatus(statusname);
				
				JSONObject assignee = (JSONObject)fields.get("assignee");
				String assigneename = "";
				String assigneeemail = "";
				if(assignee!=null) {
					
					assigneename = assignee.get("name").toString();
					assigneeemail = assignee.get("emailAddress").toString();
				}
				System.out.println("Assignee: "+assigneename);
				System.out.println("Assignee Email: "+assigneeemail);
				jira.setAssignee(assigneename);
				jira.setAssigneeEmailAddress(assigneeemail);
				
				JSONObject reporter = (JSONObject)fields.get("reporter");
				String reportername = "";
				String reporteremail = "";
				if(reporter!=null) {
					
					reportername = reporter.get("name").toString();
					reporteremail = reporter.get("emailAddress").toString();
				}
				System.out.println("Reporter: "+reportername);
				System.out.println("Reporter Email: "+reporteremail);
				jira.setReporter(reportername);
				jira.setReporterEmailAddress(reporteremail);
				
				String str_lastcomment = "Please refer JIRA for live updates - https://avikpersonal.atlassian.net/browse/"+jiraid;
				jira.setLastcomment(str_lastcomment);
				
				
				//Adding to jira issue list
				jiraissuelist.add(jira);
				System.out.println("----------------------------------------------------------------------");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return jiraissuelist;
	}
	 
	
	
}
