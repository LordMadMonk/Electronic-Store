package com.ibm.service;

import java.util.List;

import com.ibm.entity.Product;


public interface ProductService {
	
	int save(Product p);
	
	boolean update(Product p);
	
	boolean updateStock(Product p);
	
	Product fetchByID(int pid);
	
	List<Product> list();
	
	List<Product> byCategory(String category);

	List<Product> byName(String pname);

	List<Product> byPriceRange(double lowprice, double highprice);
}
