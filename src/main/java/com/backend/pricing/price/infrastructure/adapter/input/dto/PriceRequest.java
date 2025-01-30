package com.backend.pricing.price.infrastructure.adapter.input.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class PriceRequest {
    private Long priceList;
    private Integer priority;
    private Long brandId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Long productId;
    private Double price;
    private String currency;
}
