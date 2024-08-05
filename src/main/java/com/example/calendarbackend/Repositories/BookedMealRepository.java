package com.example.calendarbackend.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.calendarbackend.entity.BookedMeal;

public interface BookedMealRepository extends JpaRepository<BookedMeal, Long> {
}