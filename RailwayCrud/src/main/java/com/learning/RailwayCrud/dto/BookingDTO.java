package com.learning.RailwayCrud.dto;

import com.learning.RailwayCrud.entity.Trains;
import com.learning.RailwayCrud.entity.Users;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class BookingDTO {
    private long bookingID;
    private Users user;
    private Trains train;
    private double totalCost;
    private String trainClass;

    public BookingDTO(long bookingID, UsersDTO userInfoDTO, TrainsDTO trainInfoDTO, double totalCost, String trainClass) {
    }
}
