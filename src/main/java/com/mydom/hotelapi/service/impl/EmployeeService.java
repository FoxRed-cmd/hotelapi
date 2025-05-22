package com.mydom.hotelapi.service.impl;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.mydom.hotelapi.dto.EmployeeDto;
import com.mydom.hotelapi.mapper.EmployeeMapper;
import com.mydom.hotelapi.model.Employee;
import com.mydom.hotelapi.repository.EmployeeRepository;
import com.mydom.hotelapi.service.IEmployeeService;

@Service
public class EmployeeService implements IEmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    public EmployeeService(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper) {
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
    }

    @Override
    public List<EmployeeDto> getEmployees(int page, int size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        Page<Employee> employees = employeeRepository.findAll(pageable);
        return employees.stream().map(employeeMapper::toDto).toList();
    }

}
