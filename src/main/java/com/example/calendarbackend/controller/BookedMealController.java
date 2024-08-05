package com.example.calendarbackend.controller;

import com.example.calendarbackend.Services.BookedMealService;
import com.example.calendarbackend.dtos.BookedMealDTO;
import com.example.calendarbackend.entity.BookedMeal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/booked-meals")
public class BookedMealController {
    @Autowired
    private BookedMealService bookedMealService;

    @GetMapping
    public List<BookedMealDTO> getAllBookedMeals() {
        List<BookedMeal> bookedMeals = bookedMealService.getAllBookedMeals();
        return bookedMeals.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    public BookedMealDTO addBookedMeal(@RequestBody BookedMealDTO bookedMealDTO) {
        BookedMeal bookedMeal = convertToEntity(bookedMealDTO);
        bookedMeal = bookedMealService.addBookedMeal(bookedMeal);
        return convertToDto(bookedMeal);
    }

    @DeleteMapping("/{id}")
    public void deleteBookedMeal(@PathVariable Long id) {
        bookedMealService.deleteBookedMeal(id);
    }

    // Helper methods
    private BookedMealDTO convertToDto(BookedMeal bookedMeal) {
        return new BookedMealDTO(
                bookedMeal.getId(),
                bookedMeal.getDate(),
                bookedMeal.getEmployeeId()
        );
    }

    private BookedMeal convertToEntity(BookedMealDTO bookedMealDTO) {
        BookedMeal bookedMeal = new BookedMeal();
        bookedMeal.setId(bookedMealDTO.getId());
        bookedMeal.setDate(bookedMealDTO.getDate());
        bookedMeal.setEmployeeId(bookedMealDTO.getEmployeeId());
        return bookedMeal;
    }
}
