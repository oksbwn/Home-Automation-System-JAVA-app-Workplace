package com.oksbwn.mail;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class sendNote {

	private  String NOTE_TYPE="IDEA";
	private  String NOTE_CONTENT;
	private String username;
	private String password;
	public sendNote(String[] authentication){
		this.username=authentication[0];
		this.password=authentication[1];
		
	}
	public  boolean send(String noteType,String noteContent) {
		this.NOTE_TYPE=noteType;
		this.NOTE_CONTENT=noteContent;
		
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {

			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("oksbwn@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse("oksbwn25@gmail.com"));
			message.setSubject("NOTE"+NOTE_TYPE);
			message.setText(NOTE_CONTENT);

			Transport.send(message);

			return true;

		} catch (MessagingException e) {
		return false;
		}
	}
}