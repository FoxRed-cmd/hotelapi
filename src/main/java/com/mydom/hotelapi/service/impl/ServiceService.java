package com.mydom.hotelapi.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.mydom.hotelapi.dto.ServiceDto;
import com.mydom.hotelapi.mapper.ServiceMapper;
import com.mydom.hotelapi.repository.ServiceRepository;
import com.mydom.hotelapi.service.IServiceService;

@Service
public class ServiceService implements IServiceService {
    private final ServiceRepository serviceRepository;
    private final ServiceMapper serviceMapper;

    public ServiceService(ServiceRepository serviceRepository, ServiceMapper serviceMapper) {
        this.serviceRepository = serviceRepository;
        this.serviceMapper = serviceMapper;
    }

    @Override
    public List<ServiceDto> getAll() {
        return serviceRepository.findAll().stream().map(serviceMapper::toDto).toList();
    }

}
