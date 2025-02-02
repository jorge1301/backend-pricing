package com.backend.pricing.price.adapters.output;

import com.backend.pricing.price.adapters.output.persistence.entity.PriceEntity;
import com.backend.pricing.price.adapters.output.persistence.repository.PriceR2dbcRepository;
import com.backend.pricing.price.application.mapper.PriceMapper;
import com.backend.pricing.price.domain.entities.Price;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PriceRepositoryAdapterTest {
    @InjectMocks
    private PriceRepositoryAdapter repositoryAdapter;
    @Mock
    private PriceR2dbcRepository repository;
    @Mock
    private PriceMapper mapper;

    @Test
    void getApplicablePriceTest() {
        when(this.repository.findByBrandIdAndProductId(anyLong(), anyLong())).thenReturn(Flux.just(new PriceEntity()));
        assertNotNull(repositoryAdapter.getApplicablePrice(1L, 1L));
    }

    @Test
    void saveTest() {
        when(this.repository.save(any())).thenReturn(Mono.just(new PriceEntity()));
        assertNotNull(repositoryAdapter.save(Price.builder().build()));
    }

    @Test
    void existsPriceTest() {
        when(this.repository.existsByBrandIdAndProductIdAndStartDate(any(), any(), any()))
                .thenReturn(Mono.just(Boolean.FALSE));
        assertNotNull(repositoryAdapter.existsPrice(1L, 1L,
                LocalDateTime.now()));
    }

    @Test
    void getAllTest() {
        when(this.repository.findAll()).thenReturn(Flux.just(new PriceEntity()));
        assertNotNull(repositoryAdapter.getAll());
    }

    @Test
    void getByIdTest() {
        when(this.repository.findById(1L)).thenReturn(Mono.just(new PriceEntity()));
        assertNotNull(repositoryAdapter.getById(1L));
    }

}
