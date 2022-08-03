package com.ibm.pojo;

/**
 * @author Mrinal Samanta(@github - Mrinal_Delta)
 * @category POJO = Plain Hold Java Object
 * <p>
 * @apiNote This class is used to perform a shopping cart checkout operation controller
 * @since 0.0.1
 */

public class Checkout {
	private int cid;
    private int uid; 
    private int adid;
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getAdid() {
		return adid;
	}
	public void setAdid(int adid) {
		this.adid = adid;
	}
    
}
