package com.backend.pricing.product.application.dto.request;

import com.backend.pricing.product.application.dto.ProductDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class ProductRequestDTO {
    @Valid
    @NotNull
    private ProductDTO product;
}
