package com.ibm.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.ibm.entity.Product;
import com.ibm.service.ProductService;
/**
 * This is a product entity related controller
* @author Arup Bhattacharjee(@github - 09arup06)
* @since 0.0.1
**/
@CrossOrigin
@RestController
@RequestMapping(value="Product")
public class ProductController {
	@Autowired
	private ProductService service;
	
	@PostMapping(value="/add", consumes="application/json")
	public String save(@RequestBody Product p) {
		int pid = service.save(p);
		return "Product saved with id: " + pid;
	}
	
	@PutMapping(value="/update",consumes="application/json")
	public String update(@RequestBody Product p) {
		if(service.updateStock(p)) {
			return "Product updated successfully!!";
		}
		else
			return "failed to update";
	}
	
	@GetMapping(value="/fetch/{pid}",produces="application/json")
	public Product fetchByID(@PathVariable int pid) {
		return service.fetchByID(pid);
	}
	
	@GetMapping(value="/list",produces="application/json")
	public List<Product> list(){
		return service.list();
	}
	
	@GetMapping(value="/byCategory/{category}",produces="application/json")
	public List<Product> findByCategory(@PathVariable String category) {
		return service.byCategory(category);
	}
	
	
	@GetMapping(value="/byName/{pname}",produces="application/json")
	public List<Product> findbyName(@PathVariable String pname) {
		return service.byName(pname);
	}
	

	@GetMapping(value="/byPriceRange",produces="application/json")
	public List<Product>findByPriceRange(@RequestParam double lowp,@RequestParam double highp) {
		return service.byPriceRange(lowp, highp);
	}
	
}
