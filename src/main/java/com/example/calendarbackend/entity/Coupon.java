package com.example.calendarbackend.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String employeeName;
    private String employeeId;
    public Long getId() {
		return id;
    }
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getCouponNumber() {
		return couponNumber;
	}
	public void setCouponNumber(String couponNumber) {
		this.couponNumber = couponNumber;
	}
	public LocalDateTime getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(LocalDateTime issueDate) {
		this.issueDate = issueDate;
	}
	public LocalDateTime getRedemptionDate() {
		return redemptionDate;
	}
	public void setRedemptionDate(LocalDateTime redemptionDate) {
		this.redemptionDate = redemptionDate;
	}
	public boolean isRedeemed() {
		return redeemed;
	}
	public void setRedeemed(boolean redeemed) {
		this.redeemed = redeemed;
	}
	private String couponNumber;
    private LocalDateTime issueDate;
    private LocalDateTime redemptionDate;
    private boolean redeemed;

}
