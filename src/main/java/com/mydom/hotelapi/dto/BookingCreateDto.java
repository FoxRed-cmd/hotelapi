package com.mydom.hotelapi.dto;

import java.math.BigDecimal;
import java.util.List;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class BookingCreateDto {
    @NotBlank(message = "Room number is required")
    private String roomNumber;
    private ClientDto client;
    private String checkInDate;
    private String checkOutDate;
    private BigDecimal totalPrice;
    private List<ServiceDto> services;
}
