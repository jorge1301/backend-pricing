package com.backend.pricing.product.application.service;

import com.backend.pricing.product.application.dto.ProductDTO;
import com.backend.pricing.product.application.dto.request.ProductRequestDTO;
import com.backend.pricing.product.application.dto.response.ProductResponseDTO;
import com.backend.pricing.product.application.mapper.ProductMapper;
import com.backend.pricing.product.application.port.output.ProductRepositoryPort;
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

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {
    @InjectMocks
    private ProductService service;

    @Mock
    private ProductRepositoryPort repositoryPort;

    @Mock
    private ProductMapper mapper;

    private static ProductRequestDTO requestDTO;
    private static ProductResponseDTO responseDTO;
    private static Product product;


    @BeforeAll
    static void setup() {
        requestDTO = ProductRequestDTO.builder()
                .product(ProductDTO.builder()
                        .code(1L)
                        .description("Test Brand")
                        .build())
                .build();

        product = new Product(1L, "Test Brand");
        responseDTO = ProductResponseDTO.builder()
                .product(ProductDTO.builder()
                        .code(1L)
                        .description("Test Brand").build())
                .build();
    }

    @Test
    void saveBrandTest() {
        doReturn(product).when(this.mapper).fromRequest(any(ProductRequestDTO.class));
        doReturn(responseDTO).when(this.mapper).fromProduct(any(Product.class));
        doReturn(Mono.just(product)).when(this.repositoryPort).save(any());
        Mono<ProductResponseDTO> resultMono = this.service.saveProduct(requestDTO);
        StepVerifier.create(resultMono)
                .expectNext(responseDTO)
                .verifyComplete();
    }


    @Test
    void getBrandTestWithId() {
        doReturn(responseDTO).when(this.mapper).fromProduct(any(Product.class));
        doReturn(Mono.just(product)).when(this.repositoryPort).getById(any());
        Flux<ProductResponseDTO> resultMono = this.service.getProduct(1L);
        StepVerifier.create(resultMono)
                .expectNext(responseDTO)
                .verifyComplete();
    }

    @Test
    void getBrandTestWithoutId() {
        doReturn(responseDTO).when(this.mapper).fromProduct(any(Product.class));
        doReturn(Flux.just(product)).when(this.repositoryPort).getAll();
        Flux<ProductResponseDTO> resultMono = this.service.getProduct(null);
        StepVerifier.create(resultMono)
                .expectNext(responseDTO)
                .verifyComplete();
    }
}