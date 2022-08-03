package com.ibm.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibm.entity.Coupon;

/**
 * This is a coupon entity related repository
* @author Mrinal Samanta(@github - Mrinal_Delta)
* @since 0.0.1
**/

public interface CouponRepository extends JpaRepository<Coupon, Integer> {

}
