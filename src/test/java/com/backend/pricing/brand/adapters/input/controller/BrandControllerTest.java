package com.backend.pricing.brand.adapters.input.controller;

import com.backend.pricing.brand.application.dto.request.BrandRequestDTO;
import com.backend.pricing.brand.application.dto.response.BrandResponseDTO;
import com.backend.pricing.brand.application.service.BrandService;
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
class BrandControllerTest {

    @InjectMocks
    BrandController brandController;

    @Mock
    BrandService service;

    @Test
    void getBrandTest() {
        when(service.getBrand(anyLong())).thenReturn(Flux.just(BrandResponseDTO.builder().build()));
        Flux<ResponseEntity<BrandResponseDTO>> controller = brandController.getBrand(1L);
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
        when(service.saveBrand(any())).thenReturn(Mono.just(BrandResponseDTO.builder().build()));
        Mono<ResponseEntity<BrandResponseDTO>> controller = brandController.createBrand(BrandRequestDTO.builder().build());
        controller.as(StepVerifier::create)
                .assertNext(res -> {
                    assertNotNull(res);
                    assertEquals(200, res.getStatusCode().value());
                    assertNotNull(res.getBody());
                })
                .verifyComplete();
    }


}