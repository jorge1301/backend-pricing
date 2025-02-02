package com.backend.pricing.product.application.dto.response;

import com.backend.pricing.product.application.dto.ProductDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class ProductResponseDTO {
    @Valid
    @NotNull
    private ProductDTO product;
}
