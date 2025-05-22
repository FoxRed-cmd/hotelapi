package com.mydom.hotelapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_id")
    private long id;

    @Column(name = "room_number")
    private String number;

    @Column(name = "room_type")
    private String type;

    @Column(name = "price_per_night")
    private double pricePerNight;

    @Column(name = "status")
    private String status;

    @Column(name = "capacity")
    private int capacity;

    @Column(name = "description")
    private String description;
}
