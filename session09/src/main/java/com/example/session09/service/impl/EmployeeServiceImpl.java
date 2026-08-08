package com.example.session09.service.impl;

import com.example.session09.dto.request.EmployeeRequest;
import com.example.session09.dto.response.EmployeeResponseDTO;
import com.example.session09.entity.Employee;
import com.example.session09.exception.DuplicateResourceException;
import com.example.session09.exception.ResourceNotFoundException;
import com.example.session09.mapper.EmployeeMapper;
import com.example.session09.repository.DepartmentRepository;
import com.example.session09.repository.EmployeeRepository;
import com.example.session09.service.EmployeeService;
import com.example.session09.service.UploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeMapper employeeMapper;
    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;
    private final UploadService uploadService;
    @Override
    public EmployeeResponseDTO createEmployee(EmployeeRequest dto) {
        if(departmentRepository.findById(dto.getDepartmentId()).isEmpty()) {
            throw new ResourceNotFoundException("Phòng ban không tồn tại");
        }
        if(employeeRepository.findAll().stream().anyMatch(e -> e.getEmail().equals(dto.getEmail()))){
            throw new DuplicateResourceException("Email đã tồn tại");
        }
        Employee employee = employeeMapper.toEntity(dto);
        Employee newEmployee = employeeRepository.save(employee);
        return employeeMapper.toResponseDTO(newEmployee);
    }
    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
    @Override
    public EmployeeResponseDTO updateAvatar(Long id, MultipartFile file) {
        String fileName = file.getOriginalFilename();
        if(file.getSize() < (2*1024*1024)){
            throw new IllegalArgumentException("File không được vượt quá 2MB");
        }
        if(fileName != null && !fileName.toLowerCase().endsWith(".png")&& !fileName.toLowerCase().endsWith(".jpg")&&!fileName.toLowerCase().endsWith(".jpeg")){
            throw new IllegalArgumentException("File chỉ chấp nhận .jpg, .png, .jpeg");
        }
        employeeRepository.findById(id).ifPresent(e -> {
            e.setAvatarUrl(UploadService.uploadFile(file));
            employeeRepository.save(e);
        });
        Employee newEmployee = employeeRepository.findById(id).orElse(null);
        return employeeMapper.toResponseDTO(newEmployee);
    }
}
