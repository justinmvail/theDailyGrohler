package utility;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Flags.Flag;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class Emailer {

	public static void sendEmail(String address, String subject,
								 String text, final String userName,
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
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(userName));
			message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(address));
			message.setSubject(subject);
			message.setText(text); 
			message.setContent(text, "text/html; charset=utf-8");
	        message.setSentDate(new Date());
			Transport.send(message);
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static void saveDraftMessage(String address, String subject, String text, final String userName, final String password) throws MessagingException{	
		
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
		
		Store store = session.getStore("imap");
		store.connect("imap.gmail.com", userName, password);
		 
		Folder folder = store.getFolder("[Gmail]/Drafts");
		folder.open(Folder.READ_WRITE);  
		
		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress(userName));
		message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(address));
		message.setSubject(subject);
		message.setText(text); 
		message.setContent(text, "text/html; charset=utf-8");
        message.setSentDate(new Date());		
		message.setFlag(Flag.SEEN, true);  
		folder.appendMessages(new Message[] {message});  
		 
		store.close();		
	}

}
