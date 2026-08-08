package com.example.session09.dto.response;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class DepartmentResponseDTO {
    private Long id;
    private String name;
    private String description;
}
