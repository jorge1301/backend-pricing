package com.backend.pricing.price.application.service;

import com.backend.pricing.brand.application.dto.BrandDTO;
import com.backend.pricing.brand.domain.entities.Brand;
import com.backend.pricing.common.exception.ConflictException;
import com.backend.pricing.price.application.dto.PeriodDTO;
import com.backend.pricing.price.application.dto.PriceDTO;
import com.backend.pricing.price.application.dto.request.PriceRequestDTO;
import com.backend.pricing.price.application.dto.response.PriceResponseDTO;
import com.backend.pricing.price.application.mapper.PriceMapper;
import com.backend.pricing.price.application.port.output.BrandFetcherPort;
import com.backend.pricing.price.application.port.output.PriceRepositoryPort;
import com.backend.pricing.price.application.port.output.ProductFetcherPort;
import com.backend.pricing.price.domain.entities.Price;
import com.backend.pricing.price.domain.service.PriceValidationService;
import com.backend.pricing.product.application.dto.ProductDTO;
import com.backend.pricing.product.domain.entities.Product;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.LocalDateTime;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PriceServiceTest {
    @InjectMocks
    private PriceService service;
    @Mock
    private PriceRepositoryPort repositoryPort;
    @Mock
    private BrandFetcherPort brandFetcherPort;
    @Mock
    private ProductFetcherPort productFetcherPort;
    @Mock
    private PriceValidationService validationService;
    @Mock
    private PriceMapper mapper;
    private static PriceRequestDTO requestDTO;
    private static PriceResponseDTO responseDTO;
    private static Price price;

    @BeforeAll
    static void setup() {
        requestDTO = PriceRequestDTO.builder()
                .brand(BrandDTO.builder()
                        .code(1L)
                        .description("Test Brand")
                        .build())
                .product(ProductDTO.builder()
                        .code(1L)
                        .description("Test Product")
                        .build())
                .price(PriceDTO.builder()
                        .period(PeriodDTO.builder()
                                .startDate(LocalDateTime.now())
                                .build())
                        .build())
                .build();
        price = Price.builder()
                .productId(1L)
                .brandId(1L)
                .startDate(LocalDateTime.now())
                .endDate(LocalDateTime.now().plusDays(5))
                .build();
        responseDTO = PriceResponseDTO.builder()
                .brand(BrandDTO.builder()
                        .code(1L)
                        .description("Test Brand")
                        .build())
                .product(ProductDTO.builder()
                        .code(1L)
                        .description("Test Product")
                        .build())
                .build();
    }

    @Test
    void getApplicablePriceTest() {
        doReturn(responseDTO).when(this.mapper).fromPrice(any(Price.class),
                any(Product.class), any(Brand.class));
        doReturn(Mono.just(Product.builder().build())).when(this.productFetcherPort).fetchProductById(anyLong());
        doReturn(Mono.just(Brand.builder().build())).when(this.brandFetcherPort).fetchBrandById(anyLong());
        doReturn(Flux.just(price)).when(this.repositoryPort).getApplicablePrice(any(), any());
        Mono<PriceResponseDTO> resultMono = this.service.getApplicablePrice(1L, 1L, LocalDateTime.now());
        StepVerifier.create(resultMono)
                .expectNext(responseDTO)
                .verifyComplete();
    }

    @Test
    void getSavePriceTest() {
        doReturn(price).when(this.mapper).fromRequest(any(PriceRequestDTO.class));
        doReturn(responseDTO).when(this.mapper).fromPrice(any(Price.class),
                any(Product.class), any(Brand.class));
        doReturn(Mono.just(Boolean.FALSE)).when(this.repositoryPort).existsPrice(any(),
                any(), any());
        doReturn(Mono.just(Product.builder().build())).when(this.productFetcherPort).fetchProductById(anyLong());
        doReturn(Mono.just(Brand.builder().build())).when(this.brandFetcherPort).fetchBrandById(anyLong());
        doReturn(Mono.just(price)).when(this.repositoryPort).save(any());
        Mono<PriceResponseDTO> resultMono = this.service.savePrice(requestDTO);
        StepVerifier.create(resultMono)
                .expectNext(responseDTO)
                .verifyComplete();
    }

    @Test
    void getSavePriceTestWithExistPrice() {
        doReturn(price).when(this.mapper).fromRequest(any(PriceRequestDTO.class));
        when(this.repositoryPort.existsPrice(anyLong(), anyLong(), any())).thenReturn(Mono.just(Boolean.TRUE));
        Mono<PriceResponseDTO> resultMono = this.service.savePrice(requestDTO);
        StepVerifier.create(resultMono)
                .expectError(ConflictException.class)
                .verify();
    }

    @Test
    void getPriceTest() {
        doReturn(responseDTO).when(this.mapper).fromPrice(any(Price.class),
                any(Product.class), any(Brand.class));
        doReturn(Mono.just(Product.builder().build())).when(this.productFetcherPort).fetchProductById(anyLong());
        doReturn(Mono.just(Brand.builder().build())).when(this.brandFetcherPort).fetchBrandById(anyLong());
        doReturn(Mono.just(price)).when(this.repositoryPort).getById(anyLong());
        Flux<PriceResponseDTO> resultFlux = this.service.getPrice(1L);
        StepVerifier.create(resultFlux)
                .expectNext(responseDTO)
                .verifyComplete();
    }

    @Test
    void getPriceTestWithoutId() {
        doReturn(responseDTO).when(this.mapper).fromPrice(any(Price.class),
                any(Product.class), any(Brand.class));
        doReturn(Mono.just(Product.builder().build())).when(this.productFetcherPort).fetchProductById(anyLong());
        doReturn(Mono.just(Brand.builder().build())).when(this.brandFetcherPort).fetchBrandById(anyLong());
        doReturn(Flux.just(price)).when(this.repositoryPort).getAll();
        Flux<PriceResponseDTO> resultFlux = this.service.getPrice(null);
        StepVerifier.create(resultFlux)
                .expectNext(responseDTO)
                .verifyComplete();
    }

}