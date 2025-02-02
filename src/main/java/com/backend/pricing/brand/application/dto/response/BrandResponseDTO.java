package com.backend.pricing.brand.application.dto.response;

import com.backend.pricing.brand.application.dto.BrandDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class BrandResponseDTO {
    @Valid
    @NotNull
    private BrandDTO brand;
}
