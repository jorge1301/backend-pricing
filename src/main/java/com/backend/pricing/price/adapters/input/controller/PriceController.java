package com.backend.pricing.price.adapters.input.controller;

import com.backend.pricing.price.application.dto.request.PriceRequestDTO;
import com.backend.pricing.price.application.dto.response.PriceResponseDTO;
import com.backend.pricing.price.application.service.PriceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/prices")
@RequiredArgsConstructor
public class PriceController {

    private final PriceService priceService;

    @PostMapping
    public Mono<ResponseEntity<PriceResponseDTO>> savePrice(@Valid @RequestBody PriceRequestDTO requestDTO) {
        return this.priceService.savePrice(requestDTO)
                .map(ResponseEntity::ok);
    }

    @GetMapping
    public Mono<ResponseEntity<PriceResponseDTO>> getPrice(@RequestParam("brandCode") Long brandId,
                                                           @RequestParam("productCode") Long productId,
                                                           @RequestParam("dateApplication")
                                                           @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
                                                           LocalDateTime dateApplication) {
        return this.priceService.getApplicablePrice(brandId, productId, dateApplication)
                .map(ResponseEntity::ok);
    }
}
