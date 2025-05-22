package com.mydom.hotelapi.service;

import java.util.List;
import com.mydom.hotelapi.dto.ClientDto;

public interface IClientService {
    List<ClientDto> getClients(int page, int size);
}
