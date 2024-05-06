package com.codeWithprojects.ecom.controller.admin;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codeWithprojects.ecom.entity.Coupon;
import com.codeWithprojects.ecom.exceptions.ValidationException;
import com.codeWithprojects.ecom.services.admin.coupon.AdminCouponService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/admin/coupons")
@RequiredArgsConstructor
public class AdminCouponController {
	
	private final AdminCouponService adminCouponService;
	
	@PostMapping
	public ResponseEntity<?> createcoupon(@RequestBody Coupon coupon){
		try {
		 Coupon createdCoupon = adminCouponService.createCoupon(coupon);
		 return ResponseEntity.ok(createdCoupon);
		}catch(ValidationException ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
			}
	}
	public ResponseEntity<List<Coupon>> getAllCoupons(){
		return ResponseEntity.ok(adminCouponService.getAllCoupons());
	}

}
