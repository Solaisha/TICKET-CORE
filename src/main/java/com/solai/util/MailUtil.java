package com.solai.util;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
public class MailUtil {
	
	private  MailUtil() {
	}


	
	public static void sendSimpleMail() throws EmailException{
	Email email = new SimpleEmail();
	email.setAuthenticator(new DefaultAuthenticator("solaishass@gmail.com", "solaisha23"));

	email.setSmtpPort(465);
	
	email.setDebug(false);
	email.setHostName("smtp.gmail.com");
	email.setSSLOnConnect(true);
	email.setFrom("solaishass@gmail.com");
	email.setSubject("TicketGenerated");
	email.setMsg("Hello, a ticket has been created by a user");
	email.addTo("solaividhya0295@gmail.com");
	email.setStartTLSEnabled(true);
	email.send();
	
		
	}
}
