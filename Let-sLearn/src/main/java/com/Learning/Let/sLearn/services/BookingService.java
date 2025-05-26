package com.Learning.Let.sLearn.services;

import com.Learning.Let.sLearn.dtos.BookingDTO;
import com.Learning.Let.sLearn.entity.Booking;
import com.Learning.Let.sLearn.entity.Train;
import com.Learning.Let.sLearn.entity.User;
import com.Learning.Let.sLearn.repository.BookingRepository;
import com.Learning.Let.sLearn.repository.TrainRepository;
import com.Learning.Let.sLearn.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TrainRepository trainRepository;

    private BookingDTO convertToDTO(Booking booking) {
        BookingDTO dto = new BookingDTO();
        dto.setId(booking.getId());
        dto.setUserId(booking.getUser().getId());
        dto.setTrainId(booking.getTrain().getId());
        dto.setBookingDateTime(booking.getBookingDateTime());
        dto.setNumberOfPassengers(booking.getNumberOfPassengers());
        // ... other details ...
        return dto;
    }

    private Booking convertToEntity(BookingDTO bookingDTO) {
        Booking booking = new Booking();
        booking.setId(bookingDTO.getId());

        // Fetch User and Train entities based on the IDs in the DTO
        User user = userRepository.findById(bookingDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + bookingDTO.getUserId()));
        Train train = trainRepository.findById(bookingDTO.getTrainId())
                .orElseThrow(() -> new RuntimeException("Train not found with ID: " + bookingDTO.getTrainId()));

        booking.setUser(user);
        booking.setTrain(train);
        booking.setBookingDateTime(bookingDTO.getBookingDateTime());
        booking.setNumberOfPassengers(bookingDTO.getNumberOfPassengers());
        // ... other details ...
        return booking;
    }

    public BookingDTO createBooking(BookingDTO bookingDTO) {
        Booking booking = convertToEntity(bookingDTO);
        Booking savedBooking = bookingRepository.save(booking);
        return convertToDTO(savedBooking);
    }

    public Optional<BookingDTO> getBookingById(Long id) {
        return bookingRepository.findById(id)
                .map(this::convertToDTO);
    }

    public List<BookingDTO> getAllBookings() {
        return bookingRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public List<BookingDTO> getBookingsByUserId(Long userId) {
        return bookingRepository.findByUserId(userId).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public List<BookingDTO> getBookingsByTrainId(Long trainId) {
        return bookingRepository.findByTrainId(trainId).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public Optional<BookingDTO> updateBooking(Long id, BookingDTO bookingDTO) {
        Optional<Booking> existingBooking = bookingRepository.findById(id);
        if (existingBooking.isPresent()) {
            Booking bookingToUpdate = convertToEntity(bookingDTO);
            bookingToUpdate.setId(id);
            Booking updatedBooking = bookingRepository.save(bookingToUpdate);
            return Optional.of(convertToDTO(updatedBooking));
        }
        return Optional.empty();
    }

    public boolean deleteBooking(Long id) {
        if (bookingRepository.existsById(id)) {
            bookingRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
