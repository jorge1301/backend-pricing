package com.backend.pricing.price.application.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AmountDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = -1066797458492048503L;
    @NotNull
    private BigDecimal price;
    @NotNull
    private String currency;
}
