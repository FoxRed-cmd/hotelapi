package com.mydom.hotelapi.mapper;

import org.springframework.stereotype.Component;
import com.mydom.hotelapi.dto.BookingDetailsDto;
import com.mydom.hotelapi.model.Booking;

@Component
public class BookingDetailsMapper {
    private final RoomMapper roomMapper;
    private final ClientMapper clientMapper;
    private final EmployeeMapper employeeMapper;
    private final ServiceMapper serviceMapper;

    public BookingDetailsMapper(RoomMapper roomMapper, ClientMapper clientMapper,
            EmployeeMapper employeeMapper, ServiceMapper serviceMapper) {
        this.roomMapper = roomMapper;
        this.clientMapper = clientMapper;
        this.employeeMapper = employeeMapper;
        this.serviceMapper = serviceMapper;
    }

    public BookingDetailsDto toDto(Booking booking) {
        return BookingDetailsDto.builder().room(roomMapper.toDto(booking.getRoom()))
                .checkInDate(booking.getCheckInDate()).checkOutDate(booking.getCheckOutDate())
                .totalPrice(booking.getTotalPrice()).status(booking.getStatus())
                .clients(booking.getClients().stream().map(clientMapper::toDto).toList())
                .employees(booking.getEmployees().stream().map(employeeMapper::toDto).toList())
                .services(booking.getServices().stream().map(serviceMapper::toDto).toList())
                .build();
    }
}
