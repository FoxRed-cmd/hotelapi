package com.mydom.hotelapi.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.mydom.hotelapi.dto.ClientDto;
import com.mydom.hotelapi.service.impl.ClientService;
import org.springframework.web.bind.annotation.RequestBody;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/clients")
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;

    @GetMapping
    public ResponseEntity<List<ClientDto>> getClients(@RequestParam int page,
            @RequestParam int size) {
        return ResponseEntity.ok(clientService.getClients(page, size));
    }

    @PutMapping("/update")
    public ResponseEntity<ClientDto> update(@Valid @RequestBody ClientDto clientDto) {
        return ResponseEntity.ok(clientService.update(clientDto));
    }

}
