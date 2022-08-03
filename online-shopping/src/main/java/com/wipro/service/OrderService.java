package com.wipro.service;

import java.util.List;

import com.wipro.entity.Order;
import com.wipro.pojo.Items;

public interface OrderService {
	String addOrder(Order ordr);
	
	Order getOrder(String oid);
	
	List<Order>  fetchAllByUserId(int uid);

	List<Items> viewProducts(String order_id);
}
