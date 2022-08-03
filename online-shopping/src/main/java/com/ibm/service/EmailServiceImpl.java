package com.ibm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
/**
 * This is a Email Service class
* @author Debarghya Dutta(@github - cap-codeDeb)
* @since 0.0.1
**/



@Service
public class EmailServiceImpl implements EmailService{
	
	@Autowired
	private JavaMailSender mailsender;
	
	public void sendEmail(String receiver, String subject, String body) {
		SimpleMailMessage message= new SimpleMailMessage();
		message.setFrom("teamsahihai@gmail.com");
		message.setTo(receiver);
		message.setText(body);
		message.setSubject(subject);
		
		mailsender.send(message);
	}

}
