package com.mydom.hotelapi.service;

import java.util.List;
import com.mydom.hotelapi.dto.ClientDto;

public interface IClientService {
    List<ClientDto> getClients(int page, int size);

    ClientDto create(ClientDto clientDto);

    ClientDto update(ClientDto clientDto);
}
