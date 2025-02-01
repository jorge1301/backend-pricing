package com.backend.pricing.price.adapters.output;


import com.backend.pricing.brand.application.port.output.BrandRepositoryPort;
import com.backend.pricing.brand.domain.entities.Brand;
import com.backend.pricing.price.application.port.output.BrandFetcherPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class BrandFetcherAdapter implements BrandFetcherPort {

    private final BrandRepositoryPort repository;

    @Override
    public Mono<Brand> fetchBrandById(Long brandId) {
        return this.repository.getById(brandId);
    }
}
