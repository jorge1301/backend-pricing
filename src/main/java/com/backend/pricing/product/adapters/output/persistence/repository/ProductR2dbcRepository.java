package com.backend.pricing.product.adapters.output.persistence.repository;


import com.backend.pricing.product.adapters.output.persistence.entity.ProductEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductR2dbcRepository extends R2dbcRepository<ProductEntity, Long> {
}
