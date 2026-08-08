package com.example.session09.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EmployeeRequest {
    private Long id;
    private String fullName;
    private String email;
    private String phone;
    private Double salary;
    private Long departmentId;
    private String avatarUrl;
}
