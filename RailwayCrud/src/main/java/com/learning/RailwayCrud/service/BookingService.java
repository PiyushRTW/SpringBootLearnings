package com.learning.RailwayCrud.service;

import com.learning.RailwayCrud.dto.BookingDTO;
import com.learning.RailwayCrud.entity.Booking;

import java.util.List;

public interface BookingService {
    List<BookingDTO> getAllBookings();

    BookingDTO saveBooking(Booking booking);

    BookingDTO getBookingById(Long id);

    BookingDTO updateBooking(Booking booking);

    void deleteBooking(Booking booking);
}
