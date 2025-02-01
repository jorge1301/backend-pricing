package com.backend.pricing.product.application.port.input;

import com.backend.pricing.product.application.dto.request.ProductRequestDTO;
import com.backend.pricing.product.application.dto.response.ProductResponseDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductUseCase {
    Mono<ProductResponseDTO> saveProduct(ProductRequestDTO requestDTO);

    Flux<ProductResponseDTO> getProduct(Long id);


}
