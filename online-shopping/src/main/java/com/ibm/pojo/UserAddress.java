package com.ibm.pojo;

/**
 * 
 * @author Anirban Bhattacharyaa(@github - AnirbanBhattacharyya24)
 * @category POJO = Plain Hold Java Object
 * <p>
 * @apiNote This class is added to accept request from user to add an address that is then passed in the service through controller	
 * @since 0.0.1 
 */
public class UserAddress {
	private int uid;
	private int aid;
	private int houseno;
	private String street;
	private String city;
	private String state;
	private int pin;
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public int getHouseno() {
		return houseno;
	}
	public void setHouseno(int houseno) {
		this.houseno = houseno;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	
	
	
}
