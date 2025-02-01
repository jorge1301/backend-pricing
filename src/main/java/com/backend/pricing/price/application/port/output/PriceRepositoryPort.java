package com.backend.pricing.price.application.port.output;

import com.backend.pricing.common.application.port.output.IRepositoryPort;
import com.backend.pricing.price.domain.entities.Price;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

public interface PriceRepositoryPort extends IRepositoryPort<Price, Long> {
    Flux<Price> getApplicablePrice(Long brandId, Long productId);

    Mono<Boolean> existsPrice(Long brandId, Long productId, LocalDateTime startDate);

}
