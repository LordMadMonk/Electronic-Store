package com.wipro.service;


/**
* @author XXXXXX XXXXXX(@github - XXXXXX)
* @since 0.0.1
* 
* This is Email Related Service Class
**/

public interface EmailService {
	
	public void sendEmail(String receiver, String subject, String body);

}
