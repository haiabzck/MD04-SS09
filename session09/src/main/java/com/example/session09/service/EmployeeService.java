package com.example.session09.service;

import com.example.session09.dto.request.EmployeeRequest;
import com.example.session09.dto.response.EmployeeResponseDTO;
import com.example.session09.entity.Employee;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface EmployeeService {
    EmployeeResponseDTO createEmployee(EmployeeRequest dto);
    List<Employee> getAllEmployees();
    EmployeeResponseDTO updateAvatar(Long id, MultipartFile file);
}
