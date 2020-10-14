package com.freshvotes.service.mapper;

import com.freshvotes.model.Vote;
import com.freshvotes.service.dto.VoteDTO;
import org.springframework.stereotype.Service;

@Service
public class VoteMapper implements EntityMapper<VoteDTO, Vote> {

    @Override
    public Vote toEntity(final VoteDTO dto) {
        return null;
    }

    @Override
    public VoteDTO toDto(final Vote entity) {
        return null;
    }
}
