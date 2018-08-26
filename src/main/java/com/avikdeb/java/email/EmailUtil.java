package com.avikdeb.java.email;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.avikdeb.java.beans.NotificationEmail;

public class EmailUtil {
	
	public EmailUtil() {
		
	}
	
	public void sendNewEmail(NotificationEmail email) {
	
		final String from = "avikdeb.select@gmail.com";
		final String password = "welcome2gmail";
		final String to = "avikdeb@gmail.com";
		
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		
		try {
			
			String subject = "NON-PROD INCIDENT : "+email.getSummary()+" - "+email.getJira_isssueid()+" raised!";

			String messageBody = "<html>"
					+"<body>"
					+"<table style=\"background-color: #EAEDED; border=\"0\">"
						+"<tr><td></td><td></td></tr>"
						+"<tr>"
							+"<td>"
								+"<table style=\"background-color: #154360; border=\"0\">"
									+"<tr>"
										+"<td>&nbsp;&nbsp;&nbsp;&nbsp;<font color=\"#EAEDED\"><h1>Non-prod Incident Management Notification</h1></font></td>"
										+"<td>&nbsp;&nbsp;&nbsp;&nbsp;<font color=\"#154360\"><h1>Non-prod Incident Management Notification</h1></font></td>"
									+"</tr>"
									+"<tr><td></td><td></td></tr>"
								+"</table>"
							+"</td>"
						+"</tr>"
						+"<tr>"
							+"<td>"
						
								+"<table style=\"background-color: #EAEDED; border=\"0\">"
							
								+"<tr><td></td><td></td></tr>"
								+"<br>"
								+"<tr>"
									+"<td><b>Reference JIRA: </b></td>"
									+"<td><font color=\"blue\">"+"https://avikpersonal.atlassian.net/browse/"+email.getJira_isssueid()+"</font></td>"
								+"</tr>"
								+"<tr>"
									+"<td><b>Priority: </b></td>"
									+"<td><font color=\"red\"><b>"+email.getPriority()+"</b></font></td>"
								+"</tr>"
									+"<td><b>Status: </b></td>"
									+"<td><font color=\"red\"><b>"+email.getJira_status()+"</b></font></td>"
								+"</tr>"
								+"<tr>"
									+"<td><b>Summary: </b></td>"
									+"<td>"+email.getSummary()+"</td>"
								+"</tr>"
								+"<tr>"
									+"<td><b>Assigned Technical Resource: </b></td>"
									+"<td>"+email.getAssignee()+" [ "+email.getAssigneeEmailAddress()+" ]"+"</td>"
								+"</tr>"
								+"<tr>"
									+"<td><b>Reported by: </b></td>"
									+"<td>"+email.getReporter()+" [ "+email.getReporterEmailAddress()+" ]"+"</td>"
								+"</tr>"	
								+"<tr>"
									+"<td><b>Created on: </b></td>"
									+"<td>"+email.getCreated_on()+"</td>"
								+"</tr>"
								+"<tr>"
									+"<td><b>Last Comment: </b></td>"
									+"<td>"+email.getLastComment()+"</td>"
								+"</tr>"
								+"<tr><td></td></tr>"	
								+"<br>"
								+"</table>"
							+"</td>"
						+"</tr>"
						+"<br>"	
						+"<tr>"
							+"<td>"
								+"<table style=\"background-color: #EAEDED; border=\"0\">"
								+"<tr><td></td></tr>"	
								+"<tr><td>"
										+"This is a system generated email, should there be any concern please contact Non-prod Incident Management team."
									+"</td></tr>"
								+"</table>"
							+"</td>"
							
						+"</tr>"
						+"<br>"
						+"<tr>"
							+"<td>"
								+"<table style=\"background-color: #EAEDED; border=\"0\">"
							
									+"<tr><td></td></tr>"
									+"<tr><td>Warm Regards,</td></tr>"
									+"<tr><td>Non-prod Incident Management Team</td></tr>"
								+"</tabele>"
							+"</td>"
							
						+"</tr>"
					+"</table>"
				+"</body>"
			+"</html>";

			//Session session = Session.getDefaultInstance(props);
			Session session = Session.getInstance(props,
					new Authenticator() {
						protected PasswordAuthentication getPasswordAuthentication() {
							return new PasswordAuthentication(from, password);
						}
					});
			
			MimeMessage msg = new MimeMessage(session);
			msg.addHeader("Content-type", "text/HTML; charset=UFT-8");
			msg.addHeader("format", "flowed");
			msg.addHeader("Content-Transfer-Encoding", "8bit");
			msg.setFrom(new InternetAddress("avikdeb.select@gmail.com"));
			msg.setReplyTo(InternetAddress.parse("avikdeb.select@gmail.com", false));
			msg.setSubject(subject, "UFT-8");
			msg.setContent(messageBody, "text/html");
			msg.setSentDate(new Date());
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			
			System.out.println("Message is ready");
			
			Transport.send(msg);
			
			System.out.println("Email sent successfully");
		
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void sendUpdateEmail(NotificationEmail email) {
		
		final String from = "avikdeb.select@gmail.com";
		final String password = "welcome2gmail";
		final String to = "avikdeb@gmail.com, avik.consult@gmail.com";
		
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		
		try {
			
			String subject = "NON-PROD INCIDENT UPDATE: "+email.getSummary()+" - "+email.getJira_isssueid()+" raised!";
			
			String messageBody = "<html>"
					+"<body>"
					+"<table style=\"background-color: #EAEDED; border=\"0\">"
						+"<tr><td></td><td></td></tr>"
						+"<tr>"
							+"<td>"
								+"<table style=\"background-color: #154360; border=\"0\">"
									+"<tr>"
										+"<td>&nbsp;&nbsp;&nbsp;&nbsp;<font color=\"#EAEDED\"><h1>Non-prod Incident Management Notification</h1></font></td>"
										+"<td>&nbsp;&nbsp;&nbsp;&nbsp;<font color=\"#154360\"><h1>Non-prod Incident Management Notification</h1></font></td>"
									+"</tr>"
									+"<tr><td></td><td></td></tr>"
								+"</table>"
							+"</td>"
						+"</tr>"
						+"<tr>"
							+"<td>"
						
								+"<table style=\"background-color: #EAEDED; border=\"0\">"
							
								+"<tr><td></td><td></td></tr>"
								+"<br>"
								+"<tr>"
									+"<td><b>Reference JIRA: </b></td>"
									+"<td><font color=\"blue\">"+"https://avikpersonal.atlassian.net/browse/"+email.getJira_isssueid()+"</font></td>"
								+"</tr>"
								+"<tr>"
									+"<td><b>Priority: </b></td>"
									+"<td><font color=\"red\"><b>"+email.getPriority()+"</b></font></td>"
								+"</tr>"
									+"<td><b>Status: </b></td>"
									+"<td><font color=\"red\"><b>"+email.getJira_status()+"</b></font></td>"
								+"</tr>"
								+"<tr>"
									+"<td><b>Summary: </b></td>"
									+"<td>"+email.getSummary()+"</td>"
								+"</tr>"
								+"<tr>"
									+"<td><b>Assigned Technical Resource: </b></td>"
									+"<td>"+email.getAssignee()+" [ "+email.getAssigneeEmailAddress()+" ]"+"</td>"
								+"</tr>"
								+"<tr>"
									+"<td><b>Reported by: </b></td>"
									+"<td>"+email.getReporter()+" [ "+email.getReporterEmailAddress()+" ]"+"</td>"
								+"</tr>"	
								+"<tr>"
									+"<td><b>Created on: </b></td>"
									+"<td>"+email.getCreated_on()+"</td>"
								+"</tr>"
								+"<tr>"
									+"<td><b>Last Comment: </b></td>"
									+"<td>"+email.getLastComment()+"</td>"
								+"</tr>"
								+"<tr><td></td></tr>"	
								+"<br>"
								+"</table>"
							+"</td>"
						+"</tr>"
						+"<br>"	
						+"<tr>"
							+"<td>"
								+"<table style=\"background-color: #EAEDED; border=\"0\">"
								+"<tr><td></td></tr>"	
								+"<tr><td>"
										+"This is a system generated email, should there be any concern please contact Non-prod Incident Management team."
									+"</td></tr>"
								+"</table>"
							+"</td>"
							
						+"</tr>"
						+"<br>"
						+"<tr>"
							+"<td>"
								+"<table style=\"background-color: #EAEDED; border=\"0\">"
							
									+"<tr><td></td></tr>"
									+"<tr><td>Warm Regards,</td></tr>"
									+"<tr><td>Non-prod Incident Management Team</td></tr>"
								+"</tabele>"
							+"</td>"
							
						+"</tr>"
					+"</table>"
				+"</body>"
			+"</html>";
			
			//Session session = Session.getDefaultInstance(props);
			Session session = Session.getInstance(props, 
					new Authenticator() {
						protected PasswordAuthentication getPasswordAuthentication() {
							return new PasswordAuthentication(from, password);
						}
					});
			
			MimeMessage msg = new MimeMessage(session);
			msg.addHeader("Content-type", "text/HTML; charset=UFT-8");
			msg.addHeader("format", "flowed");
			msg.addHeader("Content-Transfer-Encoding", "8bit");
			msg.setFrom(new InternetAddress("avikdeb.select@gmail.com"));
			msg.setReplyTo(InternetAddress.parse("avikdeb.select@gmail.com", false));
			msg.setSubject(subject, "UFT-8");
			msg.setContent(messageBody, "text/html");
			msg.setSentDate(new Date());
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			
			System.out.println("Message is ready");
			
			Transport.send(msg);
			
			System.out.println("Email sent successfully");
		
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
