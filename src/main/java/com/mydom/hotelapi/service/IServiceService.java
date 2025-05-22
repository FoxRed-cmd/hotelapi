package com.mydom.hotelapi.service;

import java.util.List;
import com.mydom.hotelapi.dto.ServiceDto;

public interface IServiceService {
    List<ServiceDto> getAll();
}
