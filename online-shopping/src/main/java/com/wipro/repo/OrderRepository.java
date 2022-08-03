package com.wipro.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.wipro.entity.Order;
import com.wipro.pojo.Items;

/**
* @author XXXXXX XXXXXX(@github - XXXXXX)
* @since 0.0.1
* 
* This is Order related repository
**/


public interface OrderRepository extends JpaRepository<Order, String> {

	
	@Query("FROM Order Where user_id=:uid")
	List<Order> findAllByUser(int uid);

	@Query(value="SELECT Products.* FROM Products INNER JOIN ordered_products ON ordered_products.order_id=:order_id AND Products.product_id=ordered_products.product_id",nativeQuery = true)
	List<Items> viewProducts(String order_id);
}
