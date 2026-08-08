package com.example.session09.controller;

import com.example.session09.dto.CandidateApplyDTO;
import com.example.session09.dto.response.ApiResponse;
import com.example.session09.dto.response.CandidateResponse;
import com.example.session09.service.CandidateService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/candidates")
public class CandidateController {
    private final CandidateService candidateService;
    @PostMapping("/apply")
    public ResponseEntity<?> createCandidate(@Valid @ModelAttribute CandidateApplyDTO candidateApplyDTO) {
        CandidateResponse candidate = candidateService.createCandidate(candidateApplyDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(candidate);
    }
}
