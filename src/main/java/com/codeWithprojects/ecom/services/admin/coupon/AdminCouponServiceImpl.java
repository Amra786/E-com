package com.codeWithprojects.ecom.services.admin.coupon;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codeWithprojects.ecom.entity.Coupon;
import com.codeWithprojects.ecom.exceptions.ValidationException;
import com.codeWithprojects.ecom.repository.CouponRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdminCouponServiceImpl implements AdminCouponService{

	private final CouponRepository couponRepository;
	
	public Coupon createCoupon(Coupon coupon) {
		if(couponRepository.existsByCode(coupon.getCode())) {
		throw new ValidationException("coupon code already exists.");
	}
	return couponRepository.save(coupon);
	}
	 
	public List<Coupon> getAllCoupons(){
		return couponRepository.findAll();

	}
}