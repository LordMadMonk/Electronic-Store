package com.wipro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.entity.Coupon;
import com.wipro.repo.CouponRepository;

/**
 * This is a coupon entity related service
* @author XXXXXX XXXXXX(@github - XXXXXX)
* @since 0.0.1
**/

@Service
public class CouponServiceImpl implements CouponService {

	@Autowired
	private CouponRepository repo;
	
	@Override
	public int addCoupon(Coupon coupon) {
		repo.save(coupon);
		return coupon.getCid();
	}

	@Override
	public Coupon fetchCoupon(int id) {
		return repo.findById(id).get();
	}

	@Override
	public List<Coupon> fetchAllCoupons() {
		return repo.findAll();
	}

}
