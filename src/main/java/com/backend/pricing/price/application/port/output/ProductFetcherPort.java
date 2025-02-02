package com.backend.pricing.price.application.port.output;

import com.backend.pricing.product.domain.entities.Product;
import reactor.core.publisher.Mono;

public interface ProductFetcherPort {
    Mono<Product> fetchProductById(Long productId);
}
