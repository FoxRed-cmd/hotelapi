package com.mydom.hotelapi.service;

import java.util.List;
import com.mydom.hotelapi.dto.RoomDto;

public interface IRoomService {
    RoomDto create(RoomDto roomDto);

    List<RoomDto> getAll();

    void deleteByNumber(String roomNumber);

    RoomDto updateByNumber(String roomNumber, RoomDto roomDto);
}
