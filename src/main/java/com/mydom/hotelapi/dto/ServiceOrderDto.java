package com.mydom.hotelapi.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import com.mydom.hotelapi.model.Booking;
import lombok.Data;

@Data
public class ServiceOrderDto {
    private Booking booking;

    private ServiceDto service;

    private LocalDate orderDate;

    private Integer quantity;

    private BigDecimal totalPrice;
}
