package com.backend.pricing.price.application.port.output;

import com.backend.pricing.brand.domain.entities.Brand;
import reactor.core.publisher.Mono;

public interface BrandFetcherPort {
    Mono<Brand> fetchBrandById(Long brandId);
}
