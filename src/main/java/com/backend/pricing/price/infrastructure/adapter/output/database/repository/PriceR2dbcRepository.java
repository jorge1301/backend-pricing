package com.backend.pricing.price.infrastructure.adapter.output.database.repository;

import com.backend.pricing.price.infrastructure.adapter.output.database.model.PriceEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface PriceR2dbcRepository extends R2dbcRepository<PriceEntity, Long> {
    Flux<PriceEntity> findByBrandIdAndProductId(
            Long productId,
            Long brandId);
}
