package com.example.session09.mapper;

import com.example.session09.dto.request.EmployeeRequest;
import com.example.session09.dto.response.EmployeeResponseDTO;
import com.example.session09.entity.Employee;

import java.util.List;

public interface EmployeeMapper {
    Employee toEntity(EmployeeRequest dto);
    EmployeeResponseDTO toResponseDTO(Employee entity);
    List<EmployeeResponseDTO> toListDTO(List<Employee> entities);
}
