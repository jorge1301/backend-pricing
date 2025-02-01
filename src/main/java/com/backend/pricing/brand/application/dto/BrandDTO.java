package com.backend.pricing.brand.application.dto;

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
public class BrandDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = -4223808046921364614L;
    private Long code;
    @NotBlank
    private String description;
}
