package com.mydom.hotelapi.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import com.mydom.hotelapi.dto.RoomDto;
import com.mydom.hotelapi.service.IRoomService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/api/v1/rooms")
public class RoomController {

    private final IRoomService roomService;

    public RoomController(IRoomService roomService) {
        this.roomService = roomService;
    }

    @PostMapping("/create")
    public ResponseEntity<RoomDto> create(@Valid @RequestBody RoomDto roomDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(roomService.create(roomDto));
    }

    @GetMapping
    public ResponseEntity<List<RoomDto>> getAll() {
        return ResponseEntity.ok(roomService.getAll());
    }

    @DeleteMapping("/delete/{number}")
    public ResponseEntity<String> deleteByNumber(@PathVariable String number) {
        roomService.deleteByNumber(number);
        return ResponseEntity.ok("The room was successfully deleted");
    }

    @PutMapping("/update/{number}")
    public ResponseEntity<RoomDto> updateByNumber(@PathVariable String number,
            @Valid @RequestBody RoomDto roomDto) {
        return ResponseEntity.ok(roomService.updateByNumber(number, roomDto));
    }

}
