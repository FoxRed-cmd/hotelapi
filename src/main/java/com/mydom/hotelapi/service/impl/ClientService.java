package com.mydom.hotelapi.service.impl;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.mydom.hotelapi.dto.ClientDto;
import com.mydom.hotelapi.mapper.ClientMapper;
import com.mydom.hotelapi.model.Client;
import com.mydom.hotelapi.repository.ClientRepository;
import com.mydom.hotelapi.service.IClientService;

@Service
public class ClientService implements IClientService {
    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    public ClientService(ClientRepository clientRepository, ClientMapper clientMapper) {
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
    }

    public List<ClientDto> getClients(int page, int size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        Page<Client> clients = clientRepository.findAll(pageable);
        return clients.stream().map(clientMapper::toDto).toList();
    }

}
