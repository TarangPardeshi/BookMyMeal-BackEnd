package com.example.calendarbackend.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.calendarbackend.entity.Coupon;

import java.util.List;

public interface CouponRepository extends JpaRepository<Coupon, Long> {
    List<Coupon> findByEmployeeId(String employeeId);
}
 