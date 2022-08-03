package com.wipro.entity;

import java.util.ArrayList;
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
* @author XXXXXXXXXXXXXXX(@github - XXXXXX)
* @since 0.0.1
**/

@Entity
@Table(name = "Products")
public class Product {
	@Id
	@Column(name = "product_id")
	private int pid;
	@Column(name = "product_name")
	private String pname;
	@Column(name = "stock")
	private int stock;
	@Column(name = "price")
	private double price;
	@Column(name = "category")
	private String category;
//	@Column(name = "image_url")
//	private String img;

	//many-to-many relation b/w shoppingcart and product
	@JsonIgnore
	@ManyToMany
	@JoinTable(name="added_products",
				joinColumns = {@JoinColumn(name="product_id")},
				inverseJoinColumns = {@JoinColumn(name="cart_id")})
	private List<ShoppingCart> prod_cart = new ArrayList<>();
	
	//many to many b/w order and products
	@JsonIgnore
	@ManyToMany
	@JoinTable(name="ordered_products",
			joinColumns = {@JoinColumn(name="product_id")},
			inverseJoinColumns = {@JoinColumn(name="order_id")})
	private List<Order> prod_ord = new ArrayList<>();
	
	//for product_id
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}

	//for product_name
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}

	//for product_stock
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}

	//for product_price
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	//for product_category
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}

	//for products in a shoppingcart
	@JsonIgnore
	public List<ShoppingCart> getProd_cart() {
		return prod_cart;
	}
	@JsonIgnore
	public void setProd_cart(List<ShoppingCart> prod_cart) {
		this.prod_cart = prod_cart;
	}

	//for products in an order
	@JsonIgnore
	public List<Order> getProd_ord() {
		return prod_ord;
	}
	@JsonIgnore
	public void setProd_ord(List<Order> prod_ord) {
		this.prod_ord = prod_ord;
	}

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", stock=" + stock + ", price=" + price + ", category="
				+ category + "]";
	}

}
