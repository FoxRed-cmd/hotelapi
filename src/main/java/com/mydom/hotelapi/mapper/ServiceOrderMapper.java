package com.mydom.hotelapi.mapper;

import org.mapstruct.Mapper;
import com.mydom.hotelapi.dto.ServiceOrderDto;
import com.mydom.hotelapi.model.ServiceOrder;

@Mapper(componentModel = "spring")
public interface ServiceOrderMapper {
    ServiceOrderDto toDto(ServiceOrder serviceOrder);
}
