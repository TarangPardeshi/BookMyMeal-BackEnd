package com.example.calendarbackend.Services;

import com.example.calendarbackend.Repositories.BookedMealRepository;
import com.example.calendarbackend.entity.BookedMeal;
import com.example.calendarbackend.exception.CustomException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookedMealService {
    @Autowired
    private BookedMealRepository bookedMealRepository;

    public List<BookedMeal> getAllBookedMeals() {
        try {
            return bookedMealRepository.findAll();
        } catch (Exception e) {
            throw new CustomException("Failed to fetch booked meals");
        }
    }

    @Transactional
    public BookedMeal addBookedMeal(BookedMeal bookedMeal) {
        try {
            return bookedMealRepository.save(bookedMeal);
        } catch (Exception e) {
            throw new CustomException("Failed to add booked meal");
        }
    }

    @Transactional
    public void deleteBookedMeal(Long id) {
        try {
            bookedMealRepository.deleteById(id);
        } catch (Exception e) {
            throw new CustomException("Failed to delete booked meal");
        }
    }
}
