package com.backend.pricing.brand.application.service;

import com.backend.pricing.brand.application.dto.request.BrandRequestDTO;
import com.backend.pricing.brand.application.dto.response.BrandResponseDTO;
import com.backend.pricing.brand.application.mapper.BrandMapper;
import com.backend.pricing.brand.application.port.input.BrandUseCase;
import com.backend.pricing.brand.application.port.output.BrandRepositoryPort;
import com.backend.pricing.brand.domain.entities.Brand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class BrandService implements BrandUseCase {

    private final BrandRepositoryPort repositoryPort;
    private final BrandMapper mapper;

    @Override
    public Mono<BrandResponseDTO> saveBrand(BrandRequestDTO request) {
        Brand brand = this.mapper.fromRequest(request);
        return this.repositoryPort.save(brand).map(this.mapper::fromBrand);
    }

    @Override
    public Flux<BrandResponseDTO> getBrand(Long id) {
        if (id == null) {
            return this.repositoryPort.getAll().map(this.mapper::fromBrand);
        } else {
            return this.repositoryPort.getById(id).map(this.mapper::fromBrand).flux();
        }
    }
}

