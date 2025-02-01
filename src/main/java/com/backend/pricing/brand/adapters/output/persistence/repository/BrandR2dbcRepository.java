package com.backend.pricing.brand.adapters.output.persistence.repository;


import com.backend.pricing.brand.adapters.output.persistence.entity.BrandEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandR2dbcRepository extends R2dbcRepository<BrandEntity, Long> {
}
