package com.example.session09.mapper.impl;

import com.example.session09.dto.request.EmployeeRequest;
import com.example.session09.dto.response.DepartmentResponseDTO;
import com.example.session09.dto.response.EmployeeResponseDTO;
import com.example.session09.entity.Department;
import com.example.session09.entity.Employee;
import com.example.session09.mapper.EmployeeMapper;
import com.example.session09.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class EmployeeMapperImpl implements EmployeeMapper {
    private final DepartmentRepository departmentRepository;
    @Override
    public Employee toEntity(EmployeeRequest dto) {
        Employee entity = new Employee();
        BeanUtils.copyProperties(dto, entity);
        Department department = departmentRepository.findById(dto.getDepartmentId()).orElseThrow(() -> new RuntimeException("Không tìm thấy phòng ban với ID: " + dto.getDepartmentId()));
        entity.setDepartment(department);
        return entity;
    }

    @Override
    public EmployeeResponseDTO toResponseDTO(Employee entity) {
        EmployeeResponseDTO dto = new EmployeeResponseDTO();
        BeanUtils.copyProperties(entity, dto);
        DepartmentResponseDTO department = new DepartmentResponseDTO();
        BeanUtils.copyProperties(entity.getDepartment(), department);
        dto.setDepartment(department);
        return dto;
    }
    @Override
    public List<EmployeeResponseDTO> toListDTO(List<Employee> entities) {
        List<EmployeeResponseDTO> dtoList = new ArrayList<>();
        for (Employee entity: entities) {
            EmployeeResponseDTO dto = toResponseDTO(entity);
            dtoList.add(dto);
        }
        return dtoList;
    }
}
