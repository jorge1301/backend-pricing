package com.backend.pricing.brand.adapters.output;

import com.backend.pricing.brand.adapters.output.persistence.repository.BrandR2dbcRepository;
import com.backend.pricing.brand.application.mapper.BrandMapper;
import com.backend.pricing.brand.application.port.output.BrandRepositoryPort;
import com.backend.pricing.brand.domain.entities.Brand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class BrandRepositoryAdapter implements BrandRepositoryPort {
    private final BrandR2dbcRepository repository;
    private final BrandMapper mapper;

    @Override
    public Mono<Brand> save(Brand brand) {
        return this.repository.save(this.mapper.toBrand(brand))
                .map(this.mapper::toEntity);
    }

    @Override
    public Mono<Brand> getById(Long id) {
        return this.repository.findById(id).map(this.mapper::toEntity);
    }

    @Override
    public Flux<Brand> getAll() {
        return this.repository.findAll().map(this.mapper::toEntity);
    }
}
