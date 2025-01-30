package com.backend.pricing.brand.infrastructure.adapter.input.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BrandRequest {
    private Long id;
    private String name;
}
