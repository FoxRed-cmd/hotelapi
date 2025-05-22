package com.mydom.hotelapi.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mydom.hotelapi.dto.BookingDetailsDto;
import com.mydom.hotelapi.service.impl.BookingService;

@RestController
@RequestMapping("/api/v1/bookings")
public class BookingController {
    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping
    public ResponseEntity<List<BookingDetailsDto>> getAll() {
        return ResponseEntity.ok(bookingService.getAll());
    }
}
