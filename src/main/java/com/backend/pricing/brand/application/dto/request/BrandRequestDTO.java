package com.backend.pricing.brand.application.dto.request;

import com.backend.pricing.brand.application.dto.BrandDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class BrandRequestDTO {
    @Valid
    @NotNull
    private BrandDTO brand;
}
