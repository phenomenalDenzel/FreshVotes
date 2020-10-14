package com.freshvotes.service.mapper;

import com.freshvotes.model.Feature;
import com.freshvotes.service.dto.FeatureDTO;
import org.springframework.stereotype.Service;

@Service
public class FeatureMapper implements EntityMapper<FeatureDTO, Feature> {
    @Override
    public Feature toEntity(final FeatureDTO dto) {
        return null;
    }

    @Override
    public FeatureDTO toDto(final Feature entity) {
        return null;
    }
}
