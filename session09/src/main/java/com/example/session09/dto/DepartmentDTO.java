package com.example.session09.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDTO {
    @NotBlank(message = "Tên phòng ban không được trống")
    @Size(min = 5, max = 50, message = "Tên phòng ban phải từ 5-50 ký tự")
    private String name;
    @Size(max = 100, message = "Mô tả không vượt quá 100 ký tự")
    private String description;
}
