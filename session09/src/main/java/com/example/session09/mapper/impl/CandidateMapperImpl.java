package com.example.session09.mapper.impl;

import com.example.session09.dto.CandidateApplyDTO;
import com.example.session09.dto.response.CandidateResponse;
import com.example.session09.entity.Candidate;
import com.example.session09.mapper.CandidateMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CandidateMapperImpl implements CandidateMapper {
    @Override
    public Candidate toEntity(CandidateApplyDTO dto) {
        Candidate entity = new Candidate();
        BeanUtils.copyProperties(dto,entity);
        return entity;
    }

    @Override
    public CandidateResponse toDTO(Candidate entity) {
        CandidateResponse dto = new CandidateResponse();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }
}
