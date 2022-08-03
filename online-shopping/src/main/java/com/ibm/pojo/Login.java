package com.ibm.pojo;

/**
 * @author Arpit Ayushman(@github - arpitayushman)
 * @category POJO = Plain Hold Java Object
 * <p>
 * @apiNote This class is used to validate the User based on their email and password through controller
 * @since 0.0.1
 */
public class Login {
	private String email;
	private String pass;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
}
