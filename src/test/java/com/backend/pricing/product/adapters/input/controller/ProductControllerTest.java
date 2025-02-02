package com.backend.pricing.product.adapters.input.controller;

import com.backend.pricing.product.application.dto.request.ProductRequestDTO;
import com.backend.pricing.product.application.dto.response.ProductResponseDTO;
import com.backend.pricing.product.application.service.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest {

    @InjectMocks
    ProductController productController;

    @Mock
    ProductService service;

    @Test
    void getBrandTest() {
        when(service.getProduct(anyLong())).thenReturn(Flux.just(ProductResponseDTO.builder().build()));
        Flux<ResponseEntity<ProductResponseDTO>> controller = productController.getProduct(1L);
        controller.as(StepVerifier::create)
                .assertNext(res -> {
                    assertNotNull(res);
                    assertEquals(200, res.getStatusCode().value());
                    assertNotNull(res.getBody());
                })
                .verifyComplete();
    }

    @Test
    void createBrandTest() {
        when(service.saveProduct(any())).thenReturn(Mono.just(ProductResponseDTO.builder().build()));
        Mono<ResponseEntity<ProductResponseDTO>> controller = productController.createProduct(ProductRequestDTO.builder().build());
        controller.as(StepVerifier::create)
                .assertNext(res -> {
                    assertNotNull(res);
                    assertEquals(200, res.getStatusCode().value());
                    assertNotNull(res.getBody());
                })
                .verifyComplete();
    }
}