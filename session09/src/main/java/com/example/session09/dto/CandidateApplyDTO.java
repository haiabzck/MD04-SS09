package com.example.session09.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class CandidateApplyDTO {
    @NotBlank(message = "Tên không được trống")
    private String name;
    @Email(message = "Email không hợp lệ")
    private String email;
    private MultipartFile cvUrl;
}
