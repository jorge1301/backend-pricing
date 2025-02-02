package com.backend.pricing.brand.application.port.input;

import com.backend.pricing.brand.application.dto.request.BrandRequestDTO;
import com.backend.pricing.brand.application.dto.response.BrandResponseDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BrandUseCase {
    Mono<BrandResponseDTO> saveBrand(BrandRequestDTO requestDTO);

    Flux<BrandResponseDTO> getBrand(Long id);


}
