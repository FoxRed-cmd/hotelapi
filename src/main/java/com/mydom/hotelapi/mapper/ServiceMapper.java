package com.mydom.hotelapi.mapper;

import org.mapstruct.Mapper;
import com.mydom.hotelapi.dto.ServiceDto;
import com.mydom.hotelapi.model.Service;

@Mapper(componentModel = "spring")
public interface ServiceMapper {
    Service toEntity(ServiceDto serviceDto);

    ServiceDto toDto(Service service);
}
