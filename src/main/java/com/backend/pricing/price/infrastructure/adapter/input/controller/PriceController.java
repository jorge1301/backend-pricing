package com.backend.pricing.price.infrastructure.adapter.input.controller;

import com.backend.pricing.price.application.service.PriceService;
import com.backend.pricing.price.domain.model.Price;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/prices")
@RequiredArgsConstructor
public class PriceController {

    private final PriceService priceService;

    @GetMapping
    public Mono<Price> getPrice(@RequestParam("dateApplication")
                                @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
                                LocalDateTime dateApplication) {
        return priceService.getApplicablePrice(1L, 35455L, dateApplication);
    }
}
