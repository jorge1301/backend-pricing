package com.backend.pricing.price.adapters.output;

import com.backend.pricing.product.application.port.output.ProductRepositoryPort;
import com.backend.pricing.product.domain.entities.Product;
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
class ProductFetcherAdapterTest {
    @InjectMocks
    private ProductFetcherAdapter repositoryAdapter;
    @Mock
    private ProductRepositoryPort repository;

    @Test
    void fetchProductById() {
        when(this.repository.getById(any())).thenReturn(Mono.just(new Product()));
        assertNotNull(repositoryAdapter.fetchProductById(1L));
    }
}