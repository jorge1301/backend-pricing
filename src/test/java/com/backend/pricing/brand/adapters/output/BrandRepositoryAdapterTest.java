package com.backend.pricing.brand.adapters.output;

import com.backend.pricing.brand.adapters.output.persistence.entity.BrandEntity;
import com.backend.pricing.brand.adapters.output.persistence.repository.BrandR2dbcRepository;
import com.backend.pricing.brand.application.mapper.BrandMapper;
import com.backend.pricing.brand.domain.entities.Brand;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BrandRepositoryAdapterTest {
    @InjectMocks
    private BrandRepositoryAdapter repositoryAdapter;
    @Mock
    private BrandMapper mapper;
    @Mock
    private BrandR2dbcRepository repository;


    @Test
    void saveTest() {
        when(this.repository.save(any())).thenReturn(Mono.just(new BrandEntity()));
        assertNotNull(repositoryAdapter.save(Brand.builder().build()));
    }

    @Test
    void getByIdTest() {
        when(this.repository.findById(anyLong())).thenReturn(Mono.just(new BrandEntity()));
        assertNotNull(repositoryAdapter.getById(1L));
    }

    @Test
    void getByAllTest() {
        when(this.repository.findAll()).thenReturn(Flux.just(new BrandEntity()));
        assertNotNull(repositoryAdapter.getAll());
    }
}