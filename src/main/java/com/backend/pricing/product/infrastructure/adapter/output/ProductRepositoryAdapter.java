package com.backend.pricing.product.infrastructure.adapter.output;

import com.backend.pricing.common.application.port.output.IRepositoryPort;
import com.backend.pricing.product.domain.model.Product;
import com.backend.pricing.product.infrastructure.adapter.output.database.model.ProductEntity;
import com.backend.pricing.product.infrastructure.adapter.output.database.repository.ProductR2dbcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class ProductRepositoryAdapter implements IRepositoryPort<Product, Long> {
    @Autowired
    private final ProductR2dbcRepository repository;

    public ProductRepositoryAdapter(ProductR2dbcRepository repository) {
        this.repository = repository;
    }

    @Override
    public Mono<Product> save(Product product) {
        ProductEntity entity = ProductEntity.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .build();

        return this.repository.save(entity).map(saveEntity ->
                Product.builder()
                        .id(saveEntity.getId())
                        .name(saveEntity.getName())
                        .description(saveEntity.getDescription())
                        .build());
    }

    @Override
    public Mono<Product> getById(Long id) {
        return null;
    }
}
