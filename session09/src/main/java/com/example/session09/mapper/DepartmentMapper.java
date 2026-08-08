package com.example.session09.mapper;

import com.example.session09.dto.DepartmentDTO;
import com.example.session09.dto.response.DepartmentResponseDTO;
import com.example.session09.entity.Department;

public interface DepartmentMapper {
    DepartmentResponseDTO toDTO(Department department);
    Department toEntity(DepartmentDTO departmentDTO);
}
