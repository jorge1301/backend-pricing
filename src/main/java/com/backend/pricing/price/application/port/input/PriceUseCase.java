package com.backend.pricing.price.application.port.input;

import com.backend.pricing.price.application.dto.request.PriceRequestDTO;
import com.backend.pricing.price.application.dto.response.PriceResponseDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

public interface PriceUseCase {
    Mono<PriceResponseDTO> getApplicablePrice(Long brandId, Long productId, LocalDateTime applicationDate);
    Mono<PriceResponseDTO> savePrice(PriceRequestDTO request);
    Flux<PriceResponseDTO> getPrice(Long id);
}
