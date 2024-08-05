package com.example.calendarbackend.dtos;

import java.time.LocalDate;
import java.util.Date;

public class BookedMealDTO {
    private Long id;
    private LocalDate date;
    private String employeeId;

    // Constructors
    public BookedMealDTO() {
    }

    public BookedMealDTO(Long id, LocalDate date, String employeeId) {
        this.id = id;
        this.date = date;
        this.employeeId = employeeId;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }
}
