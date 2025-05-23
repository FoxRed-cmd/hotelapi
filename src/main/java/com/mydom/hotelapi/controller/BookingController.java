package com.mydom.hotelapi.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.mydom.hotelapi.dto.BookingCreateDto;
import com.mydom.hotelapi.dto.BookingDetailsDto;
import com.mydom.hotelapi.service.impl.BookingService;
import org.springframework.web.bind.annotation.RequestBody;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/bookings")
@RequiredArgsConstructor
public class BookingController {
    private final BookingService bookingService;

    @GetMapping
    public ResponseEntity<List<BookingDetailsDto>> getAll() {
        return ResponseEntity.ok(bookingService.getAll());
    }

    @GetMapping("/active")
    public ResponseEntity<BookingDetailsDto> getActiveByRoomId(@RequestParam String roomNumber) {
        return ResponseEntity.ok(bookingService.getActiveByRoomId(roomNumber));
    }

    @PostMapping("/create")
    public ResponseEntity<BookingDetailsDto> create(
            @Valid @RequestBody BookingCreateDto bookingCreateDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(bookingService.create(bookingCreateDto));
    }

    @PutMapping("/cancel")
    public ResponseEntity<BookingDetailsDto> cancel(@RequestParam String roomNumber,
            @RequestParam String status) {
        return ResponseEntity.ok(bookingService.cancelByRoomNumber(roomNumber, status));
    }
}
