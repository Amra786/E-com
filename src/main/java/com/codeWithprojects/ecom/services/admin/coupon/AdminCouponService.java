package com.codeWithprojects.ecom.services.admin.coupon;

import java.util.List;

import com.codeWithprojects.ecom.entity.Coupon;

public interface AdminCouponService {
	
	Coupon createCoupon(Coupon coupon);
	
	List<Coupon> getAllCoupons();
}
