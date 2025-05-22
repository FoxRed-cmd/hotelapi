package com.mydom.hotelapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.mydom.hotelapi.dto.ServiceDto;
import com.mydom.hotelapi.model.Service;

@Mapper(componentModel = "spring")
public interface ServiceMapper {
    @Mapping(target = "id", ignore = true)
    Service toEntity(ServiceDto serviceDto);

    ServiceDto toDto(Service service);
}
