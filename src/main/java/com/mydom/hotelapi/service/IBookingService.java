package com.mydom.hotelapi.service;

import java.util.List;
import com.mydom.hotelapi.dto.BookingDetailsDto;

public interface IBookingService {
    List<BookingDetailsDto> getAll();
}
