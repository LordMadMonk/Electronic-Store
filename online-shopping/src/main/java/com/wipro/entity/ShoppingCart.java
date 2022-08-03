	package com.wipro.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * This is a shopping cart entity
 * @author XXXXXXXXXXXXX(@github - XXXXXXXXXXX)
 * @since 0.0.1
 */
@Entity
@Table(name="shopping_cart")
public class ShoppingCart {
	@Id
	@GeneratedValue
	@Column(name="cart_id")
	private int cartid;
	private double total_price;
	
	//many-to-many relation b/w shoppingcart and product
	@JsonIgnore
	@ManyToMany
	@JoinTable(name="added_products",
				joinColumns = {@JoinColumn(name="cart_id")},
				inverseJoinColumns = {@JoinColumn(name="product_id")})
	private List<Product> shop_cart = new ArrayList<>();
	
	@OneToOne
	@JoinColumn(name="user_id")
	private User user_cart;

	//for cart_id
	public int getCartid() {
		return cartid;
	}
	public void setCartid(int cartid) {
		this.cartid = cartid;
	}

	//for total_price
	public double getTotal_price() {
		return total_price;
	}
	public void setTotal_price(double total_price) {
		this.total_price = total_price;
	}

	//for products in a cart
	@JsonIgnore
	public List<Product> getShop_cart() {
		return shop_cart;
	}
	@JsonIgnore
	public void setShop_cart(List<Product> shop_cart) {
		this.shop_cart = shop_cart;
	}

	//for user_id
	public User getUser_cart() {
		return user_cart;
	}
	public void setUser_cart(User user_cart) {
		this.user_cart = user_cart;
	}

	
	
	
}
