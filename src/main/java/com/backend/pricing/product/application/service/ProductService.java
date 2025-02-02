package com.backend.pricing.product.application.service;

import com.backend.pricing.product.application.dto.request.ProductRequestDTO;
import com.backend.pricing.product.application.dto.response.ProductResponseDTO;
import com.backend.pricing.product.application.mapper.ProductMapper;
import com.backend.pricing.product.application.port.input.ProductUseCase;
import com.backend.pricing.product.application.port.output.ProductRepositoryPort;
import com.backend.pricing.product.domain.entities.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ProductService implements ProductUseCase {

    private final ProductRepositoryPort repositoryPort;
    private final ProductMapper mapper;

    @Override
    public Mono<ProductResponseDTO> saveProduct(ProductRequestDTO request) {
        Product product = mapper.fromRequest(request);
        return this.repositoryPort.save(product)
                .map(this.mapper::fromProduct);
    }

    @Override
    public Flux<ProductResponseDTO> getProduct(Long id) {
        if (id == null) {
            return this.repositoryPort.getAll().map(this.mapper::fromProduct);
        } else {
            return this.repositoryPort.getById(id).map(this.mapper::fromProduct).flux();
        }
    }
}

