package com.mydom.hotelapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.mydom.hotelapi.dto.EmployeeDto;
import com.mydom.hotelapi.model.Employee;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    @Mapping(target = "id", ignore = true)
    Employee toEntity(EmployeeDto employee);

    EmployeeDto toDto(Employee employee);
}
