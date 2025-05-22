package com.mydom.hotelapi.service.impl;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.mydom.hotelapi.dto.RoomDto;
import com.mydom.hotelapi.exception.ApiException;
import com.mydom.hotelapi.mapper.RoomMapper;
import com.mydom.hotelapi.model.Room;
import com.mydom.hotelapi.repository.RoomRepository;
import com.mydom.hotelapi.service.IRoomService;

@Service
public class RoomService implements IRoomService {

    private final RoomRepository roomRepository;
    private final RoomMapper roomMapper;

    public RoomService(RoomRepository roomRepository, RoomMapper roomMapper) {
        this.roomRepository = roomRepository;
        this.roomMapper = roomMapper;
    }

    @Override
    @Transactional
    public RoomDto create(RoomDto roomDto) {
        if (roomRepository.existsByNumber(roomDto.getNumber())) {
            throw new ApiException(HttpStatus.BAD_REQUEST,
                    "Room with number " + roomDto.getNumber() + " already exists");
        }
        var createdRoom = roomRepository.save(roomMapper.toEntity(roomDto));
        return roomMapper.toDto(createdRoom);
    }

    @Override
    public List<RoomDto> getAll() {
        return roomRepository.findAll().stream().map(roomMapper::toDto).toList();
    }

    @Override
    @Transactional
    public void deleteByNumber(String roomNumber) {
        if (!roomRepository.existsByNumber(roomNumber)) {
            throw new ApiException(HttpStatus.NOT_FOUND,
                    "Room with number " + roomNumber + " not found");
        }
        roomRepository.deleteByNumber(roomNumber);
    }

    public RoomDto updateByNumber(String roomNumber, RoomDto roomDto) {
        Room room = roomRepository.findByNumber(roomNumber)
                .orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND,
                        "Room with number " + roomDto.getNumber() + " not found"));
        Long id = room.getId();
        room = roomMapper.toEntity(roomDto);
        room.setId(id);
        return roomMapper.toDto(roomRepository.save(room));
    }
}
