package com.example.session09.mapper.impl;

import com.example.session09.dto.DepartmentDTO;
import com.example.session09.dto.response.DepartmentResponseDTO;
import com.example.session09.entity.Department;
import com.example.session09.mapper.DepartmentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class DepartmentMapperImpl implements DepartmentMapper {
    @Override
    public Department toEntity(DepartmentDTO dto) {
        Department entity = new Department();
        BeanUtils.copyProperties(dto,entity);
        return entity;
    }

    @Override
    public DepartmentResponseDTO toDTO(Department entity) {
        DepartmentResponseDTO dto = new DepartmentResponseDTO();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }
}
