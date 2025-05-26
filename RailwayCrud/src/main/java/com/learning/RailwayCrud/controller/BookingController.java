package com.learning.RailwayCrud.controller;

import com.learning.RailwayCrud.dto.BookingDTO;
import com.learning.RailwayCrud.entity.Booking;
import com.learning.RailwayCrud.service.BookingService;
import com.learning.RailwayCrud.service.implementation.BookingServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rest/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping("/list")
    private ResponseEntity<List<BookingDTO>> getAllBookings() {
        try {
            return ResponseEntity.ok(bookingService.getAllBookings());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/")
    private ResponseEntity<BookingDTO> saveBooking(@RequestBody Booking booking) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(bookingService.saveBooking(booking));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    private ResponseEntity<BookingDTO> getBookingById(@PathVariable("id") long id) {
        try {
            return ResponseEntity.ok(bookingService.getBookingById(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/")
    private ResponseEntity<BookingDTO> updateBooking(@RequestBody Booking booking) {
        try {
            return ResponseEntity.ok(bookingService.updateBooking(booking));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/")
    private ResponseEntity<Void> deleteBooking(@RequestBody Booking booking) {
        try {
            bookingService.deleteBooking(booking);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
