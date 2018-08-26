package com.avikdeb.java.beans;

public class JiraIssue {
	
	private String jiraid;
	private String summary;
	private String createdon;
	private String priority;
	private String status;
	private String label;
	private String assignee;
	private String assigneeEmailAddress;
	private String reporter;
	private String reporterEmailAddress;
	private String lastcomment;
	public String getJiraid() {
		return jiraid;
	}
	public void setJiraid(String jiraid) {
		this.jiraid = jiraid;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getCreatedon() {
		return createdon;
	}
	public void setCreatedon(String createdon) {
		this.createdon = createdon;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
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
	public String getLastcomment() {
		return lastcomment;
	}
	public void setLastcomment(String lastcomment) {
		this.lastcomment = lastcomment;
	}

}
