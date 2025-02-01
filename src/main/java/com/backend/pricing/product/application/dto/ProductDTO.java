package com.backend.pricing.product.application.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = -5150472546197109581L;
    private Long code;
    @NotBlank
    private String description;
}
