package com.avikdeb.java.mgr;

import com.avikdeb.java.beans.NotificationEmail;
import com.avikdeb.java.email.EmailUtil;

public class NotificationManager {

	public NotificationManager() {
		
	}
	
	public void sendNewNotificationEmail(NotificationEmail email) {
		
		EmailUtil sendEmail = new EmailUtil();
		sendEmail.sendNewEmail(email);
	}
	
	public void sendUpdateNotificationEmail(NotificationEmail email) {
		
		EmailUtil sendEmail = new EmailUtil();
		sendEmail.sendUpdateEmail(email);
	}
	
}
