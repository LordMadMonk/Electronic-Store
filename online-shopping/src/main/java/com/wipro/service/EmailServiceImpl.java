package com.wipro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
/**
 * This is a Email Service class
* @author XXXXXX XXXXXX(@github - XXXXXX)
* @since 0.0.1
**/



@Service
public class EmailServiceImpl implements EmailService{
	
	@Autowired
	private JavaMailSender mailsender;
	
	public void sendEmail(String receiver, String subject, String body) {
		SimpleMailMessage message= new SimpleMailMessage();
		message.setFrom("demomailformyproject@gmail.com");
		message.setTo(receiver);
		message.setText(body);
		message.setSubject(subject);
		
		mailsender.send(message);
	}

}
