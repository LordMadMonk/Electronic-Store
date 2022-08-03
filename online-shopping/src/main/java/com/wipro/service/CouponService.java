package com.wipro.service;

import java.util.List;

import com.wipro.entity.Coupon;

/**
 * This is a coupon entity related service interface
* @author XXXXXX XXXXXX(@github - XXXXXX)
* @since 0.0.1
**/

public interface CouponService {
	int addCoupon(Coupon coupon);
	
	Coupon fetchCoupon(int id);
	
	List<Coupon> fetchAllCoupons();
}
