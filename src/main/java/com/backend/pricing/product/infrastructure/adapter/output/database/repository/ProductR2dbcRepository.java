package com.backend.pricing.product.infrastructure.adapter.output.database.repository;

import com.backend.pricing.product.infrastructure.adapter.output.database.model.ProductEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductR2dbcRepository extends R2dbcRepository<ProductEntity, Long> {
}
