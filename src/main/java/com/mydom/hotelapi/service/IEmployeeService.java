package com.mydom.hotelapi.service;

import java.util.List;
import com.mydom.hotelapi.dto.EmployeeDto;

public interface IEmployeeService {
    List<EmployeeDto> getEmployees(int page, int size);
}
