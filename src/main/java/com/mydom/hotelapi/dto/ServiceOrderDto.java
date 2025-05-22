package com.mydom.hotelapi.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.Data;

@Data
public class ServiceOrderDto {
    private ServiceDto service;

    private LocalDate orderDate;

    private Integer quantity;

    private BigDecimal totalPrice;
}
