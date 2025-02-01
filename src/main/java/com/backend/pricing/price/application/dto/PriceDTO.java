package com.backend.pricing.price.application.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
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
public class PriceDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = -2918201970786726290L;

    @Valid
    @NotNull
    private PriceDetailsDTO details;

    @Valid
    @NotNull
    private PeriodDTO period;

    @Valid
    @NotNull
    private AmountDTO amount;
}
