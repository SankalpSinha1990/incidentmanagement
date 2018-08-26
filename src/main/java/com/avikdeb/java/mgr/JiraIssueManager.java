package com.avikdeb.java.mgr;

import java.util.ArrayList;
import java.util.Iterator;

import com.avikdeb.java.beans.JiraIssue;
import com.avikdeb.java.beans.NotificationEmail;
import com.avikdeb.java.jiraapi.JiraApiCall;
import com.avikdeb.java.metadata.JiraConstants;
import com.avikdeb.java.metadata.MailTypeConstants;
import com.avikdeb.java.util.HostOSChecker;
import com.avikdeb.java.util.JiraDataParser;
import com.avikdeb.java.util.JiraResultFileFormatter;

public class JiraIssueManager implements JiraConstants, MailTypeConstants {
	
	private static ArrayList<JiraIssue> jiraIssueList;

	//New blockers
	private static void notifyNewBlockers(ArrayList<JiraIssue> jiraIssueList) {
		
		//emailList = new ArrayList<NotificationEmail>();
		if(jiraIssueList.size()!=0) {
			
			Iterator<JiraIssue> jiraIterator = jiraIssueList.iterator();
			
			while(jiraIterator.hasNext()) {
				
				JiraIssue jiraIssue = jiraIterator.next();
				NotificationEmail email = new NotificationEmail(jiraIssue);
				NotificationManager nmgr = new NotificationManager();
				
				System.out.println("In Issue Manager ::: Status - "+jiraIssue.getStatus());
				
				if(jiraIssue.getStatus().trim().equalsIgnoreCase(JiraConstants.JIRA_STATUS_TODO.trim())) {
					email.setMailType(MailTypeConstants.TYPE_NEW_INCIDENT);
					nmgr.sendNewNotificationEmail(email);
				} else if(jiraIssue.getStatus().trim().equalsIgnoreCase(JiraConstants.JIRA_STATUS_INPROGRESS.trim())) {
					email.setMailType(MailTypeConstants.TYPE_UPDATE_INCIDENT);
					nmgr.sendUpdateNotificationEmail(email);
				} else if(jiraIssue.getStatus().trim().equalsIgnoreCase(JiraConstants.JIRA_STATUS_CLOSED.trim())) {
					email.setMailType(MailTypeConstants.TYPE_CLOSE_INCIDENT);
					//to be implemented
				}
			}
		}
		
	}
	
	private static void formatJSONFile() {
		
		String filename = "";
		
		HostOSChecker os = HostOSChecker.getInstance();
		if(os.getOsName().equalsIgnoreCase("windows 7")) {
			filename = "C:\\incident_home\\jira_jql.json";
		} else {
			filename = "user/home/incident_home/jira_jql.json";
		}
		
		int startline = 1;
		int numline = 16;
		
		JiraResultFileFormatter.removeHeader(filename, startline, numline);
	}
	
	
	/*==================================================================================
	   Main program
	  ==================================================================================*/
	public static void main(String[] args) {
		
		formatJSONFile();
		
		JiraDataParser parser = new JiraDataParser();
		jiraIssueList = parser.getJiraIssueList();
		notifyNewBlockers(jiraIssueList);
		
		System.out.println("----------------------------------------------------------------------");
		System.out.println("Framework Engine exucuted successfully.");
		System.out.println("Please check your e-mails for updates.");
		System.out.println("----------------------------------------------------------------------");
	}
}
