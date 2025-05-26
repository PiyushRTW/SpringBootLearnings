package com.Learning.Let.sLearn.controllers;

import com.Learning.Let.sLearn.dtos.BookingDTO;
import com.Learning.Let.sLearn.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping
    public ResponseEntity<BookingDTO> createBooking(@RequestBody BookingDTO bookingDTO) {
        try {
            BookingDTO createdBooking = bookingService.createBooking(bookingDTO);
            return new ResponseEntity<>(createdBooking, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            System.err.println("Error creating booking: " + e.getMessage());
            // Return a ResponseEntity with an error status and a message
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST); // Or another appropriate error status
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookingDTO> getBookingById(@PathVariable Long id) {
        Optional<BookingDTO> bookingDTO = bookingService.getBookingById(id);
        return bookingDTO.map(dto -> new ResponseEntity<>(dto, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<BookingDTO>> getAllBookings() {
        List<BookingDTO> bookings = bookingService.getAllBookings();
        return new ResponseEntity<>(bookings, HttpStatus.OK);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<List<BookingDTO>> getBookingsByUserId(@PathVariable Long userId) {
        List<BookingDTO> bookings = bookingService.getBookingsByUserId(userId);
        return new ResponseEntity<>(bookings, HttpStatus.OK);
    }

    @GetMapping("/trains/{trainId}")
    public ResponseEntity<List<BookingDTO>> getBookingsByTrainId(@PathVariable Long trainId) {
        List<BookingDTO> bookings = bookingService.getBookingsByTrainId(trainId);
        return new ResponseEntity<>(bookings, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookingDTO> updateBooking(@PathVariable Long id, @RequestBody BookingDTO bookingDTO) {
        try {
            Optional<BookingDTO> updatedBookingDTO = bookingService.updateBooking(id, bookingDTO);
            return updatedBookingDTO.map(dto -> new ResponseEntity<>(dto, HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        }
        catch (RuntimeException e) {
            System.err.println("Error creating booking: " + e.getMessage());
            // Return a ResponseEntity with an error status and a message
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST); // Or another appropriate error status
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable Long id) {
        if (bookingService.deleteBooking(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}