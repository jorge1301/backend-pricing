package com.backend.pricing.brand.application.mapper;

import com.backend.pricing.brand.adapters.output.persistence.entity.BrandEntity;
import com.backend.pricing.brand.application.dto.request.BrandRequestDTO;
import com.backend.pricing.brand.application.dto.response.BrandResponseDTO;
import com.backend.pricing.brand.domain.entities.Brand;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BrandMapper {
    Brand toEntity(BrandEntity entity);

    @InheritInverseConfiguration(name = "toEntity")
    BrandEntity toBrand(Brand brand);

    @Mapping(target = "brand.code", source = "id")
    @Mapping(target = "brand.description", source = "name")
    BrandResponseDTO fromBrand(Brand brand);

    @Mapping(target = "id", source = "brand.code")
    @Mapping(target = "name", source = "brand.description")
    Brand fromRequest(BrandRequestDTO request);
}
