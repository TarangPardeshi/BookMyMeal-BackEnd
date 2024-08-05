// CouponController.java
package com.example.calendarbackend.controller;

import com.example.calendarbackend.Services.CouponService;
import com.example.calendarbackend.entity.Coupon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/coupons")
public class CouponController {
    @Autowired
    private CouponService couponService;

    @GetMapping
    public List<Coupon> getAllCoupons() {
        return couponService.getAllCoupons();
    }

    @GetMapping("/{employeeId}")
    public List<Coupon> getCouponsByEmployeeId(@PathVariable String employeeId) {
        return couponService.getCouponsByEmployeeId(employeeId);
    }

    @PostMapping
    public Coupon addCoupon(@RequestBody Coupon coupon) {
        return couponService.addCoupon(coupon);
    }

    @PostMapping("/redeem/{couponId}")
    public Coupon redeemCoupon(@PathVariable Long couponId) {
        return couponService.redeemCoupon(couponId);
    }
}
