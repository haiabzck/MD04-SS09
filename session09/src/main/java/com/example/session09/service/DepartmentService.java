package com.example.session09.service;

import com.example.session09.dto.DepartmentDTO;
import com.example.session09.dto.response.DepartmentResponseDTO;

public interface DepartmentService {
    DepartmentResponseDTO createDepartment(DepartmentDTO dto);
}
