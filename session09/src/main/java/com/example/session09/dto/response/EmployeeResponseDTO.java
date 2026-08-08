package com.example.session09.dto.response;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class EmployeeResponseDTO {
    private Long id;
    private String fullName;
    private String email;
    private String phone;
    private Double salary;
    private DepartmentResponseDTO department;
    private String avatarUrl;
}
