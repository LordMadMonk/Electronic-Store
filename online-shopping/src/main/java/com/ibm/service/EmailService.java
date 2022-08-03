package com.ibm.service;


/**
* @author Debarghya Dutta(@github - cap-codeDeb)
* @since 0.0.1
* 
* This is Email Related Service Class
**/

public interface EmailService {
	
	public void sendEmail(String receiver, String subject, String body);

}
