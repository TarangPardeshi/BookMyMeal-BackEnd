// CouponService.java
package com.example.calendarbackend.Services;

import com.example.calendarbackend.Repositories.CouponRepository;
import com.example.calendarbackend.entity.Coupon;
import com.example.calendarbackend.exception.CustomException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CouponService {
    @Autowired
    private CouponRepository couponRepository;

    public List<Coupon> getAllCoupons() {
        try {
            return couponRepository.findAll
            		();
        } catch (Exception e) {
            throw new CustomException("Failed to fetch coupons");
        }
    }

    public List<Coupon> getCouponsByEmployeeId(String employeeId) {
        try {
            return couponRepository.findByEmployeeId(employeeId);
        } catch (Exception e) {
            throw new CustomException("Failed to fetch coupons for employee");
        }
    }

    @Transactional
    public Coupon addCoupon(Coupon coupon) {
        try {
            coupon.setIssueDate(LocalDateTime.now());
            coupon.setRedeemed(false);
            return couponRepository.save(coupon);
        } catch (Exception e) {
            throw new CustomException("Failed to add coupon");
        }
    }

    @Transactional
    public Coupon redeemCoupon(Long couponId) {
        try {
            Coupon coupon = couponRepository.findById(couponId)
                    .orElseThrow(() -> new CustomException("Coupon not found"));
            if (coupon.isRedeemed()) {
                throw new CustomException("Coupon already redeemed");
            }
            coupon.setRedeemed(true);
            coupon.setRedemptionDate(LocalDateTime.now());
            return couponRepository.save(coupon);
        } catch (Exception e) {
            throw new CustomException("Failed to redeem coupon");
        }
    }
}
