package com.learning.RailwayCrud.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "booking")
public class Booking{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long bookingID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userID")
    private Users user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trainID")
    private Trains train;

    @Column(nullable = false,name = "price")
    private double totalCost;

    @Column(nullable = false)
    private String trainClass;

}
