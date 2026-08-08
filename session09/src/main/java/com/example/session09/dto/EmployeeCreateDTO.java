package com.example.session09.dto;

import com.example.session09.entity.Department;
import jakarta.validation.constraints.*;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeCreateDTO {
    @NotBlank(message = "Tên không được trống")
    private String fullName;
    @Email(message = "Email không hợp lệ")
    private String email;
    @Pattern(regexp = "^(03|05|07|08|09)\\d{8}$", message = "Số điện thoại VN: 10 số, bắt đầu bằng 03,05,07,08,09")
    private String phone;
    @Min(value = 5000000 , message = "Lương tối thiểu 5000000")
    private Double salary;
    @NotNull(message = "Id phòng không được trống")
    private Department department;
    private String avatarUrl;
}
