package com.example.calendarbackend.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.calendarbackend.Repositories.BookingRepository;
import com.example.calendarbackend.dtos.BookingDTO;
import com.example.calendarbackend.entity.Booking;
import com.example.calendarbackend.exception.BookingNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Optional<Booking> getBookingById(Long id) {
        return bookingRepository.findById(id);
    }

    @Transactional
    public Booking saveBooking(BookingDTO bookingDTO) {
        Booking booking = new Booking();
        booking.setStartDate(bookingDTO.getStartDate());
        booking.setEndDate(bookingDTO.getEndDate());
        booking.setEmployeeId(bookingDTO.getEmployeeId());
        return bookingRepository.save(booking);
    }

//    @Transactional
    public void deleteBooking(Long id) {
        if (!bookingRepository.existsById(id)) {
            throw new BookingNotFoundException("Booking not found with id: " + id);
        }
        bookingRepository.deleteById(id);
    }
}
