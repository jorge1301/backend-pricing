package com.backend.pricing.price.adapters.output;


import com.backend.pricing.price.application.port.output.ProductFetcherPort;
import com.backend.pricing.product.application.port.output.ProductRepositoryPort;
import com.backend.pricing.product.domain.entities.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class ProductFetcherAdapter implements ProductFetcherPort {

    private final ProductRepositoryPort repository;

    @Override
    public Mono<Product> fetchProductById(Long productId) {
        return this.repository.getById(productId);
    }
}
