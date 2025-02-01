package com.backend.pricing.product.adapters.output;

import com.backend.pricing.product.adapters.output.persistence.repository.ProductR2dbcRepository;
import com.backend.pricing.product.application.mapper.ProductMapper;
import com.backend.pricing.product.application.port.output.ProductRepositoryPort;
import com.backend.pricing.product.domain.entities.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class ProductRepositoryAdapter implements ProductRepositoryPort {
    private final ProductR2dbcRepository repository;
    private final ProductMapper mapper;

    @Override
    public Mono<Product> save(Product product) {
        return this.repository.save(this.mapper.toProduct(product))
                .map(this.mapper::toEntity);
    }

    @Override
    public Mono<Product> getById(Long id) {
        return this.repository.findById(id).map(this.mapper::toEntity);
    }

    @Override
    public Flux<Product> getAll() {
        return this.repository.findAll().map(this.mapper::toEntity);
    }
}
