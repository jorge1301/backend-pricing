package com.backend.pricing.product.adapters.output;

import com.backend.pricing.product.adapters.output.persistence.entity.ProductEntity;
import com.backend.pricing.product.adapters.output.persistence.repository.ProductR2dbcRepository;
import com.backend.pricing.product.application.mapper.ProductMapper;
import com.backend.pricing.product.domain.entities.Product;
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
class ProductRepositoryAdapterTest {
    @InjectMocks
    private ProductRepositoryAdapter repositoryAdapter;
    @Mock
    private ProductMapper mapper;
    @Mock
    private ProductR2dbcRepository repository;

    @Test
    void saveTest() {
        when(this.repository.save(any())).thenReturn(Mono.just(new ProductEntity()));
        assertNotNull(repositoryAdapter.save(Product.builder().build()));
    }

    @Test
    void getByIdTest() {
        when(this.repository.findById(anyLong())).thenReturn(Mono.just(new ProductEntity()));
        assertNotNull(repositoryAdapter.getById(1L));
    }

    @Test
    void getByAllTest() {
        when(this.repository.findAll()).thenReturn(Flux.just(new ProductEntity()));
        assertNotNull(repositoryAdapter.getAll());
    }
}