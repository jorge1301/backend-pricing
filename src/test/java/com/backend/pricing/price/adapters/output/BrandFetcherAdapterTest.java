package com.backend.pricing.price.adapters.output;

import com.backend.pricing.brand.application.port.output.BrandRepositoryPort;
import com.backend.pricing.brand.domain.entities.Brand;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BrandFetcherAdapterTest {
    @InjectMocks
    private BrandFetcherAdapter repositoryAdapter;
    @Mock
    private BrandRepositoryPort repository;

    @Test
    void fetchBrandById() {
        when(this.repository.getById(any())).thenReturn(Mono.just(new Brand()));
        assertNotNull(repositoryAdapter.fetchBrandById(1L));
    }

}