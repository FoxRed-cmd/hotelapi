package com.mydom.hotelapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.mydom.hotelapi.dto.ClientDto;
import com.mydom.hotelapi.model.Client;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    @Mapping(target = "id", ignore = true)
    Client toEntity(ClientDto clientDto);

    ClientDto toDto(Client client);
}
