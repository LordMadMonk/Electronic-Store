package com.wipro.service;

import java.util.List;

import com.wipro.entity.ShoppingCart;
import com.wipro.pojo.Items;
import com.wipro.pojo.UserProduct;

/**
* This is a shopping cart entity related service interface
* @author XXXXXX XXXXXX(@github - XXXXXX)
* @since 0.0.1
*/
public interface ShoppingCartServcie {
	
	int createCart(int uid);
	
	ShoppingCart fetchCart(int uid);
	
	List<Items> viewCart(int uid);
	
	double addToCart(UserProduct up) throws Exception;
	
	String checkout(int cid,int uid,int adid) throws Exception;
	
}
