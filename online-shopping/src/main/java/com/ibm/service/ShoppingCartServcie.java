package com.ibm.service;

import java.util.List;

import com.ibm.entity.ShoppingCart;
import com.ibm.pojo.Items;
import com.ibm.pojo.UserProduct;

/**
* This is a shopping cart entity related service interface
* @author Mrinal Samanta(@github - Mrinal_Delta)
* @since 0.0.1
*/
public interface ShoppingCartServcie {
	
	int createCart(int uid);
	
	ShoppingCart fetchCart(int uid);
	
	List<Items> viewCart(int uid);
	
	double addToCart(UserProduct up) throws Exception;
	
	String checkout(int cid,int uid,int adid) throws Exception;
	
}
