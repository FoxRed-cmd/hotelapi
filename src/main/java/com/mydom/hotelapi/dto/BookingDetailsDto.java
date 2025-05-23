package com.mydom.hotelapi.dto;

import java.math.BigDecimal;
import java.security.Provider.Service;
import java.time.LocalDate;
import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookingDetailsDto {
    private Long id;
    private RoomDto room;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private BigDecimal totalPrice;
    private String status;
    private List<ClientDto> clients;
    private List<EmployeeDto> employees;
    private List<ServiceOrderDto> services;
}
