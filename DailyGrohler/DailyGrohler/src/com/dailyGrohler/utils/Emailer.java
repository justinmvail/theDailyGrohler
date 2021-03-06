package com.dailyGrohler.utils;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;
import com.sun.mail.smtp.SMTPMessage;

public class Emailer {
	
	public static void sendEmail(String address, String subject,
								 String text, String picturePath, final String userName,
								 final String password) throws Exception{		
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
 
		Session session = Session.getInstance(props,
			new Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(userName, password);
				}
			}
		);
 
		try {			
			SMTPMessage message = new SMTPMessage(session);
			MimeMultipart content = new MimeMultipart();
			MimeBodyPart mainPart = new MimeBodyPart();			
			MimeBodyPart imagePart = new MimeBodyPart();
			mainPart.setText(text);							
			imagePart.attachFile(picturePath);			
			message.setContent(content);			
			content.addBodyPart(mainPart);
			content.addBodyPart(imagePart);			
			message.setFrom(new InternetAddress(userName));
			message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(address));
			Transport.send(message);
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}	
}
