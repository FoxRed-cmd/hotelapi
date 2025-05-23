package com.mydom.hotelapi.mapper;

import org.mapstruct.Mapper;
import com.mydom.hotelapi.dto.ClientDto;
import com.mydom.hotelapi.model.Client;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    Client toEntity(ClientDto clientDto);

    ClientDto toDto(Client client);
}
