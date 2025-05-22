package com.mydom.hotelapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.mydom.hotelapi.dto.RoomDto;
import com.mydom.hotelapi.model.Room;

@Mapper(componentModel = "spring")
public interface RoomMapper {
    @Mapping(target = "id", ignore = true)
    Room toEntity(RoomDto dto);

    RoomDto toDto(Room room);
}
