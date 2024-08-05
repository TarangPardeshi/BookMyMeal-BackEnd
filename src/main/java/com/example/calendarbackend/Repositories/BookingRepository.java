package com.example.calendarbackend.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.calendarbackend.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
