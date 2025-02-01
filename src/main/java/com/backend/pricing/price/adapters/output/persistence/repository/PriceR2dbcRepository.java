package com.backend.pricing.price.adapters.output.persistence.repository;

import com.backend.pricing.price.adapters.output.persistence.entity.PriceEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Repository
public interface PriceR2dbcRepository extends R2dbcRepository<PriceEntity, Long> {
    Flux<PriceEntity> findByBrandIdAndProductId(
            Long productId,
            Long brandId);

    Mono<Boolean> existsByBrandIdAndProductIdAndStartDate(Long brandId, Long productId, LocalDateTime startDate);

}
