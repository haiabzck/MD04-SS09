package com.example.session09.mapper;

import com.example.session09.dto.CandidateApplyDTO;
import com.example.session09.dto.response.CandidateResponse;
import com.example.session09.entity.Candidate;

public interface CandidateMapper {
    Candidate toEntity(CandidateApplyDTO candidateApplyDTO);
    CandidateResponse toDTO(Candidate candidate);
}
