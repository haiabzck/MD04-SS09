package com.example.session09.service;

import com.example.session09.dto.CandidateApplyDTO;
import com.example.session09.dto.response.CandidateResponse;
import com.example.session09.entity.Candidate;
import com.example.session09.mapper.CandidateMapper;
import com.example.session09.repository.CandidateRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CandidateService {
    private final CandidateRepository candidateRepository;
    private final CandidateMapper candidateMapper;
    @Transactional
    public CandidateResponse createCandidate(CandidateApplyDTO applyDTO) {
        Candidate candidate = new Candidate();
        candidate.setName(applyDTO.getName());
        candidate.setEmail(applyDTO.getEmail());
        if(applyDTO.getCvUrl() == null || !applyDTO.getCvUrl().getOriginalFilename().endsWith(".pdf")){
            throw new IllegalArgumentException("Yêu cầu file là pdf và không được trống");
        }
        candidate.setCvUrl(UploadService.uploadFile(applyDTO.getCvUrl()));
        candidateRepository.save(candidate);
        return candidateMapper.toDTO(candidate);
    }
}
