package com.ibm.pojo;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author Mrinal Samanta(@github - Mrinal_Delta)
 * @category Projection POJO
 * <p>
 * @apiNote This interface is used for obtaining products based on order and shopping_cart
 * @since 0.0.1
 */
public interface Items {
//	 product_id | category | product_name    | price | stock
	
	@Value("#{target.product_id}")
	Integer getPid();
	
	@Value("#{target.product_name}")
	String getPname();
	
	@Value("#{target. price}")
	Integer getPrice();
	
	@Value("#{target.category}")
	String getCategory();
	
	@Value("#{target.stock}")
	Integer getStock();
}
