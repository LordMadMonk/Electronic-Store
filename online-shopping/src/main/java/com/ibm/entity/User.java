package com.ibm.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
* @author Arpit Ayushman(@github - arpitayushman)
* @since 0.0.1
**/

@Entity
@Table(name = "Users")
public class User {
	@Id
	@Column(name="user_id")
	private int userId;
	@Column(name="user_name",length = 30)
	private String username;
	@Column(name="email",length = 50, unique = true)
	private String email;
	@Column(name="password",length=15)
	private String password;
	@Column(length = 15)
	private String phone_number;
	
	//one to many relation b/w user and order
	@JsonManagedReference
	@JsonIgnore
	@OneToMany(mappedBy = "userord")
	private List<Order> user_orders = new ArrayList<>();
	
	//one to many relation b/w user and address
	@JsonManagedReference
	@JsonIgnore
	@OneToMany(mappedBy = "useradd")
	private List<Address> user_addresses = new ArrayList<>();
	
	//many to many b/w user and coupon
	@JsonIgnore
	@ManyToMany
	@JoinTable(name="used_coupons",
				joinColumns = @JoinColumn(name="user_id"),
				inverseJoinColumns = @JoinColumn(name="coupon_id"))
	private List<Coupon> user_coup = new ArrayList<>();
	
	//for user_id
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	//for user_name
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	//for email
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	//for password
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	//for phone_number
	public String getPhone_number() {
		return phone_number;
	}
	
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	
	
	//for user_order
	@JsonManagedReference
	@JsonIgnore
	public List<Order> getUser_orders() {
		return user_orders;
	}
	@JsonManagedReference
	@JsonIgnore
	public void setUser_orders(List<Order> user_orders) {
		this.user_orders = user_orders;
	}

	//for user_address
	@JsonManagedReference
	@JsonIgnore
	public List<Address> getUser_addresses() {
		return user_addresses;
	}
	@JsonManagedReference
	@JsonIgnore
	public void setUser_addresses(List<Address> user_addresses) {
		this.user_addresses = user_addresses;
	}
	
	//for coupons
	@JsonIgnore
	public List<Coupon> getUser_coup() {
		return user_coup;
	}
	@JsonIgnore
	public void setUser_coup(List<Coupon> user_coup) {
		this.user_coup = user_coup;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", email=" + email + ", password=" + password
				+ ", phone_number=" + phone_number + ", user_orders="
				+ user_orders + ", user_addresses=" + user_addresses + ", user_coup=" + user_coup + "]";
	}

	
	
	
}
