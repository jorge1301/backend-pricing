package com.backend.pricing.brand.infrastructure.adapter.output;

import com.backend.pricing.brand.domain.model.Brand;
import com.backend.pricing.brand.infrastructure.adapter.output.database.model.BrandEntity;
import com.backend.pricing.brand.infrastructure.adapter.output.database.repository.BrandR2dbcRepository;
import com.backend.pricing.common.application.port.output.IRepositoryPort;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
@Component
public class BrandRepositoryAdapter implements IRepositoryPort<Brand, Long> {
    private final BrandR2dbcRepository repository;

    public BrandRepositoryAdapter(BrandR2dbcRepository repository) {
        this.repository = repository;
    }

    @Override
    public Mono<Brand> save(Brand brand) {
        BrandEntity entity = BrandEntity.builder()
                .id(brand.getId())
                .name(brand.getName())
                .build();

        return this.repository.save(entity).map(saveEntity ->
                Brand.builder()
                        .id(saveEntity.getId())
                        .name(saveEntity.getName())
                        .build());
    }

    @Override
    public Mono<Brand> getById(Long id) {
        return null;
    }
}
