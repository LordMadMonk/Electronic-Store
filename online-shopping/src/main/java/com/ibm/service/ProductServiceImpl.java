package com.ibm.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.entity.Product;


import com.ibm.repo.ProductRepository;
/**
 * This is a product entity related service
* @author Arup Bhattacharjee(@github - 09arup06)
* @since 0.0.1
**/
@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository repo;

	//For Adding Products
	@Override
	public int save(Product p) {
		repo.save(p);
		return  p.getPid();

	}

	//For Updating Products
	@Override
	public boolean update(Product p) {
		repo.save(p);
		return true;
	}
	
	@Override
	public boolean updateStock(Product p) {
		Product prod = repo.findById(p.getPid()).get();
		prod.setStock(p.getStock());
		repo.save(prod);
		return true;
	}
	
	//Fetching products by their product id
	@Override
	public Product fetchByID(int pid) {
		return repo.findById(pid).get();
	}
	
	//Getting the list of all products
	@Override
	public List<Product> list() {
		return (List<Product>) repo.findAll();
	}	
	
	//Getting products by searching their category
	@Override
	public List<Product> byCategory(String category) {
		return repo.findByCategory(category);
	}

	//Getting products by searching product names
	@Override
	public List<Product> byName(String pname)  {
		return repo.findByPname(pname);
	}
	
	//Getting products based on their prices
	@Override
	public List<Product> byPriceRange(double lowprice, double highprice){
		return repo.findByPriceRange(lowprice, highprice);
	}

	


}
