package com.ibm.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * This is a coupon entity
* @author Mrinal Samanta(@github - Mrinal_Delta)
* @since 0.0.1
**/

@Entity
@Table(name="Coupons")
public class Coupon {
	@Id
	@Column(name="coupon_id")
	private int cid;
	@Column(name="coupon_name")
	private String cname;
	@Column(name="discount")
	private double discount;
	
	//many to many relation b/w coupon and users
	@JsonIgnore
	@ManyToMany
	@JoinTable(name="used_coupons",
				joinColumns = @JoinColumn(name="coupon_id"),
				inverseJoinColumns = @JoinColumn(name="user_id"))
	private List<User> coup_user;
	
	//for coupon_id
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}

	//for coupon_name
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}

	//for discount_value
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}

	//for user and coupon 
	@JsonIgnore
	public List<User> getCoup_user() {
		return coup_user;
	}
	@JsonIgnore
	public void setCoup_user(List<User> coup_user) {
		this.coup_user = coup_user;
	}

	
	
	
}
