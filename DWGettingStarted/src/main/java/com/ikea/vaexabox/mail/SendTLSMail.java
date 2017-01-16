package com.ikea.vaexabox.mail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.ikea.vaexabox.core.Registration;

public class SendTLSMail {
	 
	static Properties mailServerProperties;
	static Session getMailSession;
	static MimeMessage generateMailMessage;
  
	public static void generateAndSendEmail(TLSMail tlsm, Registration registration, String location, int visitors) throws AddressException, MessagingException {
 
		// Step1
		System.out.println("\n 1st ===> setup Mail Server Properties..");
		mailServerProperties = System.getProperties();
		mailServerProperties.put("mail.smtp.port", tlsm.getSmtpport());
		mailServerProperties.put("mail.smtp.auth", "true");
		mailServerProperties.put("mail.smtp.starttls.enable", "true");
		System.out.println("Mail Server Properties have been setup successfully..");
 
		// Step2
		System.out.println("\n\n 2nd ===> get Mail Session..");
		getMailSession = Session.getDefaultInstance(mailServerProperties, null);
		generateMailMessage = new MimeMessage(getMailSession);
		generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(registration.email));
		//generateMailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress("test2@crunchify.com"));
		generateMailMessage.setSubject("Visitor Events from location: "+location);
		String emailBody = "Email by Raspi. " +"<br>"+visitors+" new visitors have tried to contact you<br><br> Regards, <br>Raspi Admin";
		generateMailMessage.setContent(emailBody, "text/html");
		System.out.println("Mail Session has been created successfully..");
 
		// Step3
		System.out.println("\n\n 3rd ===> Get Session and Send mail");
		Transport transport = getMailSession.getTransport("smtp");
 
		// Enter your correct gmail UserID and Password
		// if you have 2FA enabled then provide App Specific Password
		transport.connect(tlsm.getSmtphost(), tlsm.getSmtpuser(), tlsm.getSmtppassword());
		transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
		transport.close();
	}
}
