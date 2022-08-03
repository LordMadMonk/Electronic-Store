package com.ibm.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.entity.Coupon;
import com.ibm.service.CouponService;

/**
 * This is a coupon entity related controller
* @author Mrinal Samanta(@github - Mrinal_Delta)
* @since 0.0.1
**/
@CrossOrigin
@RestController
@RequestMapping(value="Coupon")
public class CouponController {

	@Autowired
	private CouponService service;
	
	@PostMapping(value="add",consumes="application/json")
	public String addCoupon(@RequestBody Coupon c) {//working
		service.addCoupon(c);
		return "Coupon with ID: "+c.getCid()+" has been added";
	}
	
	@GetMapping(value="fetch",produces="application/json")
	public Coupon fetchCoupon(@RequestParam int cid) {//working
		return service.fetchCoupon(cid);
	}
	
	@GetMapping(value="fetchAll",produces="application/json")
	public List<Coupon> fetchAllCoupon() {//working
		return service.fetchAllCoupons();
	}
}
