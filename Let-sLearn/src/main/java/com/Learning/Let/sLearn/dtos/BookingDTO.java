package com.Learning.Let.sLearn.dtos;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class BookingDTO {
    private Long id;
    private Long userId;
    private Long trainId;
    private LocalDateTime bookingDateTime;
    private Integer numberOfPassengers;
    // ... other booking details ...
}
