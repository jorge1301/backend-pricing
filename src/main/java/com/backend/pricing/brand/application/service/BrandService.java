package com.backend.pricing.brand.application.service;

import com.backend.pricing.brand.domain.model.Brand;
import com.backend.pricing.common.application.port.input.ICommandUseCase;
import com.backend.pricing.common.application.port.input.IQueryUseCase;
import com.backend.pricing.common.application.port.output.IRepositoryPort;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class BrandService implements IQueryUseCase<Brand, Long>,
        ICommandUseCase<Brand, Long> {

    private final IRepositoryPort<Brand, Long> repositoryPort;

    public BrandService(IRepositoryPort<Brand, Long> repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    @Override
    public Mono<Brand> save(Brand object) {
        return this.repositoryPort.save(object);
    }

    @Override
    public Mono<Brand> getById(Long id) {
        return this.repositoryPort.getById(id);
    }
}

