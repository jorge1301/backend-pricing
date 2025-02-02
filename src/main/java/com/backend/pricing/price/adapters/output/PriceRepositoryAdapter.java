package com.backend.pricing.price.adapters.output;


import com.backend.pricing.price.adapters.output.persistence.repository.PriceR2dbcRepository;
import com.backend.pricing.price.application.mapper.PriceMapper;
import com.backend.pricing.price.application.port.output.PriceRepositoryPort;
import com.backend.pricing.price.domain.entities.Price;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class PriceRepositoryAdapter implements PriceRepositoryPort {

    private final PriceR2dbcRepository repository;
    private final PriceMapper mapper;

    @Override
    public Flux<Price> getApplicablePrice(Long brandId, Long productId) {
        return this.repository.findByBrandIdAndProductId(brandId, productId)
                .map(this.mapper::toEntity);
    }

    @Override
    public Mono<Boolean> existsPrice(Long brandId, Long productId, LocalDateTime startDate) {
        return this.repository.existsByBrandIdAndProductIdAndStartDate(brandId,
                productId, startDate);
    }

    @Override
    public Mono<Price> save(Price price) {
        return this.repository.save(this.mapper.toPrice(price))
                .map(this.mapper::toEntity);
    }

    @Override
    public Mono<Price> getById(Long id) {
        return this.repository.findById(id).map(this.mapper::toEntity);
    }

    @Override
    public Flux<Price> getAll() {
        return this.repository.findAll().map(this.mapper::toEntity);
    }
}
