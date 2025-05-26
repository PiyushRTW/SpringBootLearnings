package com.learning.RailwayCrud.service.implementation;

import com.learning.RailwayCrud.dto.BookingDTO;
import com.learning.RailwayCrud.dto.TrainsDTO;
import com.learning.RailwayCrud.dto.UsersDTO;
import com.learning.RailwayCrud.entity.Booking;
import com.learning.RailwayCrud.repository.BookingRepository;
import com.learning.RailwayCrud.repository.TrainsRepository;
import com.learning.RailwayCrud.repository.UsersRepository;
import com.learning.RailwayCrud.service.BookingService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookingServicesImpl implements BookingService {

    @Autowired
    private BookingRepository bookingrepository;
    private UsersRepository userRepository;
    private TrainsRepository trainRepository;

    private BookingDTO mapBookingToDTO(Booking booking){
        UsersDTO userInfoDTO = new UsersDTO(booking.getUser().getUserID(), booking.getUser().getUser_name());
        TrainsDTO trainInfoDTO = new TrainsDTO(booking.getTrain().getTrainId(), booking.getTrain().getTrain_Name());

        return new BookingDTO(booking.getBookingID(), userInfoDTO, trainInfoDTO, booking.getTotalCost(), booking.getTrainClass());
    }

    @Override
    public List<BookingDTO> getAllBookings() {
        List<Booking> bookinglist = bookingrepository.findAll();
        List<BookingDTO> bookings = new ArrayList<>();

        for(Booking booking : bookinglist){
            bookings.add(mapBookingToDTO(booking));
        }
        return bookings;
    }

    @Override
    public BookingDTO saveBooking(Booking booking) {
        Booking savedBooking = bookingrepository.save(booking);
        return mapBookingToDTO(savedBooking);
    }

    @Override
    public BookingDTO getBookingById(Long id) {
       Optional<Booking> bookingOptional = bookingrepository.findById(id);
       if(bookingOptional.isPresent()){
           return this.mapBookingToDTO(bookingOptional.get());
       }
       else{
           return null;
       }
    }

    @Override
    public BookingDTO updateBooking(Booking booking) {
        Booking updatedBooking = bookingrepository.save(booking);
        return this.mapBookingToDTO(updatedBooking);
    }

    @Override
    public void deleteBooking(Booking booking) {
        bookingrepository.delete(booking);
    }
}
