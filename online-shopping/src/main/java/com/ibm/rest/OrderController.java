package com.ibm.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.entity.Order;
import com.ibm.pojo.Items;
import com.ibm.service.OrderService;
/**
 * This is a order entity related controller
* @author Debarghya Dutta(@github - cap-codeDeb)
* @since 0.0.1
**/

@CrossOrigin
@RestController
@RequestMapping(value="Order")
public class OrderController {
	
	@Autowired
	private OrderService service;
	
	@GetMapping(value = "/getById/{oid}",produces = "application/json")
	public Order getOrder(@PathVariable String oid) {
		return service.getOrder(oid);
	}
	
	@GetMapping(value="/get/{uid}", produces="application/json")
	public List<Order> fetchOrders(@PathVariable int uid){
		return service.fetchAllByUserId(uid);
	}

	@GetMapping(value="/details/{order_id}",produces="application/json")
	public List<Items> viewDetails(@PathVariable String order_id){
		return service.viewProducts(order_id);
	}
}
