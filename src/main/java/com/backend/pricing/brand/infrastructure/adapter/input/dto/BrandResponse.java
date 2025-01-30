package com.backend.pricing.brand.infrastructure.adapter.input.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class BrandResponse {
    private Long id;
    private String name;
}
