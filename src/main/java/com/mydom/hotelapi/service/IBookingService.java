package com.mydom.hotelapi.service;

import java.util.List;
import com.mydom.hotelapi.dto.BookingCreateDto;
import com.mydom.hotelapi.dto.BookingDetailsDto;

public interface IBookingService {
    List<BookingDetailsDto> getAll();

    BookingDetailsDto getActiveByRoomId(String roomNumber);

    BookingDetailsDto create(BookingCreateDto bookingCreateDto);

    BookingDetailsDto cancelByRoomNumber(String roomNumber, String status);
}
