package com.mydom.hotelapi.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.mydom.hotelapi.dto.BookingDetailsDto;
import com.mydom.hotelapi.mapper.BookingDetailsMapper;
import com.mydom.hotelapi.repository.BookingRepository;
import com.mydom.hotelapi.service.IBookingService;

@Service
public class BookingService implements IBookingService {
    private final BookingRepository bookingRepository;
    private final BookingDetailsMapper bookingDetailsMapper;

    public BookingService(BookingRepository bookingRepository,
            BookingDetailsMapper bookingDetailsMapper) {
        this.bookingRepository = bookingRepository;
        this.bookingDetailsMapper = bookingDetailsMapper;
    }

    @Override
    public List<BookingDetailsDto> getAll() {
        return bookingRepository.findAll().stream().map(bookingDetailsMapper::toDto).toList();
    }

}
