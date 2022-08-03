package com.ibm.pojo;


/**
 * @author Arup Bhattacharjee(@github - 09arup06)
 * @category POJO = Plain Hold Java Object
 * <p>
 * @apiNote This class is used to add a product to a users cart
 * @since 0.0.1
 */
public class UserProduct {
	private int uid;
	private int pid;
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	
}
