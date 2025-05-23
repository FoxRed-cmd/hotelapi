package com.mydom.hotelapi.service.impl;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.mydom.hotelapi.dto.ClientDto;
import com.mydom.hotelapi.exception.ApiException;
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

    @Override
    public List<ClientDto> getClients(int page, int size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        Page<Client> clients = clientRepository.findAll(pageable);
        return clients.stream().map(clientMapper::toDto).toList();
    }

    @Override
    public ClientDto create(ClientDto clientDto) {
        Client client = clientMapper.toEntity(clientDto);
        return clientMapper.toDto(clientRepository.save(client));
    }

    @Override
    @Transactional
    public ClientDto update(ClientDto clientDto) {
        Client client = clientRepository.findById(clientDto.getId())
                .orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, "Client not found"));
        Long id = client.getId();
        client = clientMapper.toEntity(clientDto);
        client.setId(id);
        return clientMapper.toDto(clientRepository.save(client));
    }

}
