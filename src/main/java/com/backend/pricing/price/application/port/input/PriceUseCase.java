package com.backend.pricing.price.application.port.input;

import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

public interface PriceUseCase<Price, PriceId> {
    Mono<Price> getApplicablePrice(Long brandId, Long productId, LocalDateTime applicationDate);

}
