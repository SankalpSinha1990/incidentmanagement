package com.avikdeb.java.beans;

import com.avikdeb.java.util.CustomDateTimeFormatter;

public class NotificationEmail {
	
	private String jira_isssueid;
	private String summary;
	private String created_on;
	private String priority;
	private String jira_status;
	private String assignee;
	private String assigneeEmailAddress;
	private String reporter;
	private String reporterEmailAddress;
	private String lastComment;
	
	private String mailType = "";
	
	public NotificationEmail(JiraIssue jira) {
			
		jira_isssueid = jira.getJiraid();
		summary = jira.getSummary();
		created_on = jira.getCreatedon();
		priority = jira.getPriority();
		jira_status = jira.getStatus();
		assignee = jira.getAssignee();
		assigneeEmailAddress = jira.getAssigneeEmailAddress();
		reporter = jira.getReporter();
		reporterEmailAddress = jira.getReporterEmailAddress();
		lastComment = jira.getLastcomment();
	}

	public String getJira_isssueid() {
		return jira_isssueid;
	}

	public void setJira_isssueid(String jira_isssueid) {
		this.jira_isssueid = jira_isssueid;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getCreated_on() {
		CustomDateTimeFormatter formatter = new CustomDateTimeFormatter();
		created_on = formatter.getFormattedDate(this.created_on)+" : "+formatter.getFormattedTime(this.created_on);
		return created_on;
	}

	public void setCreated_on(String created_datetime) {
		CustomDateTimeFormatter formatter = new CustomDateTimeFormatter();
		created_on = formatter.getFormattedDate(created_on)+" : "+formatter.getFormattedTime(created_datetime);
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getJira_status() {
		return jira_status;
	}

	public void setJira_status(String jira_status) {
		this.jira_status = jira_status;
	}

	public String getAssignee() {
		return assignee;
	}

	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}

	public String getAssigneeEmailAddress() {
		return assigneeEmailAddress;
	}

	public void setAssigneeEmailAddress(String assigneeEmailAddress) {
		this.assigneeEmailAddress = assigneeEmailAddress;
	}

	public String getReporter() {
		return reporter;
	}

	public void setReporter(String reporter) {
		this.reporter = reporter;
	}

	public String getReporterEmailAddress() {
		return reporterEmailAddress;
	}

	public void setReporterEmailAddress(String reporterEmailAddress) {
		this.reporterEmailAddress = reporterEmailAddress;
	}

	public String getLastComment() {
		return lastComment;
	}

	public void setLastComment(String lastComment) {
		this.lastComment = lastComment;
	}

	public String getMailType() {
		return mailType;
	}

	public void setMailType(String mailType) {
		this.mailType = mailType;
	}
	
	
}
