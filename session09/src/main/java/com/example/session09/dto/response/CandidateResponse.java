package com.example.session09.dto.response;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class CandidateResponse {
    private int id;
    private String name;
    private String email;
    private String cvUrl;
}
