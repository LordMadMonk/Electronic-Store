package com.wipro.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.entity.Coupon;

/**
 * This is a coupon entity related repository
* @author XXXXXX XXXXXX(@github - XXXXXX)
* @since 0.0.1
**/

public interface CouponRepository extends JpaRepository<Coupon, Integer> {

}
