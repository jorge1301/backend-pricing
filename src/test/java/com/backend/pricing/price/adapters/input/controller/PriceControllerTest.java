package com.backend.pricing.price.adapters.input.controller;

import com.backend.pricing.price.application.dto.request.PriceRequestDTO;
import com.backend.pricing.price.application.dto.response.PriceResponseDTO;
import com.backend.pricing.price.application.service.PriceService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PriceControllerTest {


    @InjectMocks
    PriceController priceController;

    @Mock
    PriceService service;

    @Test
    void savePriceTest() {
        when(service.savePrice(any())).thenReturn(Mono.just(PriceResponseDTO.builder().build()));
        Mono<ResponseEntity<PriceResponseDTO>> controller = priceController
                .savePrice(PriceRequestDTO.builder().build());
        controller.as(StepVerifier::create)
                .assertNext(res -> {
                    assertNotNull(res);
                    assertEquals(200, res.getStatusCode().value());
                    assertNotNull(res.getBody());
                })
                .verifyComplete();
    }

    @Test
    void getPriceTest() {
        when(service.getApplicablePrice(any(), any(), any())).thenReturn(Mono.just(PriceResponseDTO.builder().build()));
        Mono<ResponseEntity<PriceResponseDTO>> controller = priceController
                .getPrice(1L, 1L, LocalDateTime.now());
        controller.as(StepVerifier::create)
                .assertNext(res -> {
                    assertNotNull(res);
                    assertEquals(200, res.getStatusCode().value());
                    assertNotNull(res.getBody());
                })
                .verifyComplete();
    }

}