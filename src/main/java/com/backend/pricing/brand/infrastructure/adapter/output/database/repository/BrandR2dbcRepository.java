package com.backend.pricing.brand.infrastructure.adapter.output.database.repository;


import com.backend.pricing.brand.infrastructure.adapter.output.database.model.BrandEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandR2dbcRepository extends R2dbcRepository<BrandEntity, Long> {
}
