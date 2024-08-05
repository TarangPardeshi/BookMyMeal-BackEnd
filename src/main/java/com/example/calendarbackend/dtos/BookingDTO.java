package com.example.calendarbackend.dtos;

import java.time.LocalDate;

public class BookingDTO {
    private LocalDate startDate;
    private LocalDate endDate;
    private String employeeId;

    // Getters and setters
    public LocalDate getStartDate() {
        return startDate;
    }
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
    public LocalDate getEndDate() {
        return endDate;
    }
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
    public String getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }
}
