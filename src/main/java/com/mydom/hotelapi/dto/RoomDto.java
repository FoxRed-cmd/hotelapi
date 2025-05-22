package com.mydom.hotelapi.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RoomDto {

    @NotBlank(message = "Room number is required")
    @Size(max = 10, message = "Room number must be less than 10 characters")
    private String number;

    @NotBlank(message = "Room type is required")
    @Size(max = 50, message = "Room type must be less than 50 characters")
    private String type;

    @NotNull(message = "Price per night is required")
    @Positive(message = "Price must be positive")
    private double pricePerNight;

    @NotBlank(message = "Status is required")
    private String status;

    @NotNull(message = "Capacity is required")
    @Min(value = 1, message = "Capacity must be at least 1")
    private int capacity;

    private String description;
}
