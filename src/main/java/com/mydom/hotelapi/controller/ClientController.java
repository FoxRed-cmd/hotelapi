package com.mydom.hotelapi.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.mydom.hotelapi.dto.ClientDto;
import com.mydom.hotelapi.service.impl.ClientService;

@RestController
@RequestMapping("/api/v1/clients")
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public ResponseEntity<List<ClientDto>> getClients(@RequestParam int page,
            @RequestParam int size) {
        return ResponseEntity.ok(clientService.getClients(page, size));
    }

}
