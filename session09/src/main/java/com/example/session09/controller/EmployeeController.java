package com.example.session09.controller;

import com.example.session09.dto.request.EmployeeRequest;
import com.example.session09.dto.response.EmployeeResponseDTO;
import com.example.session09.entity.Employee;
import com.example.session09.mapper.EmployeeMapper;
import com.example.session09.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {
    private final EmployeeService employeeService;
    private final EmployeeMapper employeeMapper;
    @PostMapping
    public ResponseEntity<?> createEmployee(@Valid @RequestBody EmployeeRequest dto) {
        EmployeeResponseDTO newDto = employeeService.createEmployee(dto);
        return new ResponseEntity<>(newDto, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<EmployeeResponseDTO>> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        List<EmployeeResponseDTO> responseDTOs = employeeMapper.toListDTO(employees);
        return new ResponseEntity<>(responseDTOs, HttpStatus.OK);
    }

    @PutMapping("/{id}/avatar")
    public ResponseEntity<?> updateAvatar(@PathVariable Long id, @RequestParam MultipartFile file) {
        EmployeeResponseDTO newDto = employeeService.updateAvatar(id, file);
        return new ResponseEntity<>(newDto,HttpStatus.OK);
    }
}
