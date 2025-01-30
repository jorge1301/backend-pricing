package com.backend.pricing.product.application.service;

import com.backend.pricing.common.application.port.input.ICommandUseCase;
import com.backend.pricing.common.application.port.input.IQueryUseCase;
import com.backend.pricing.common.application.port.output.IRepositoryPort;
import com.backend.pricing.product.domain.model.Product;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class ProductService implements IQueryUseCase<Product, Long>,
        ICommandUseCase<Product, Long> {

    private final IRepositoryPort<Product, Long> repositoryPort;

    public ProductService(IRepositoryPort<Product, Long> repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    @Override
    public Mono<Product> save(Product object) {
        return this.repositoryPort.save(object);
    }

    @Override
    public Mono<Product> getById(Long id) {
        return this.repositoryPort.getById(id);
    }
}

