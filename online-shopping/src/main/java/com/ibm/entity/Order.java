package com.ibm.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;


/**
* @author Debarghya Dutta(@github - cap-codeDeb)
* @since 0.0.1
* 
* This is Order related Entity
**/


@Entity
@Table(name="Orders")
public class Order {
	@Id
	@Column(name="order_id")
	private String oid;
	
	@Column(name="total_price")
	private double totalprice;
	
	@Column(name="status")
	private String status;
	
	@Column(name="date")
	private LocalDate date;
	
	//many to one relation b/w order and user
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="user_id")
	private User userord;
	
	//many to one relation b/w order and address
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="address_id")
	private Address addOrd;
	
	//many to many b/w order and products
	@JsonIgnore
	@ManyToMany
	@JoinTable(name="ordered_products",
				joinColumns = {@JoinColumn(name = "order_id")},
				inverseJoinColumns = {@JoinColumn(name="product_id")})
	private List<Product> product_list = new ArrayList<>();

	//for order_id
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}

	//for total_price
	public double getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}

	//for status
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	//for date
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}

	//for user_id
	@JsonBackReference
	public User getUserord() {
		return userord;
	}
	@JsonBackReference
	public void setUserord(User userord) {
		this.userord = userord;
	}

	//for address_id
	@JsonBackReference
	public Address getAddOrd() {
		return addOrd;
	}
	@JsonBackReference
	public void setAddOrd(Address addOrd) {
		this.addOrd = addOrd;
	}

	//for list of products in a order
	@JsonIgnore
	public List<Product> getProduct_list() {
		return product_list;
	}
	@JsonIgnore
	public void setProduct_list(List<Product> product_list) {
		this.product_list = product_list;
	}
	
	
	
}
