package com.example.session09.service.impl;

import com.example.session09.dto.DepartmentDTO;
import com.example.session09.dto.response.DepartmentResponseDTO;
import com.example.session09.entity.Department;
import com.example.session09.mapper.DepartmentMapper;
import com.example.session09.repository.DepartmentRepository;
import com.example.session09.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final DepartmentMapper departmentMapper;

    @Override
    public DepartmentResponseDTO createDepartment(DepartmentDTO dto) {
       Department department = departmentMapper.toEntity(dto);
       departmentRepository.save(department);
        return departmentMapper.toDTO(department);
    }

}
