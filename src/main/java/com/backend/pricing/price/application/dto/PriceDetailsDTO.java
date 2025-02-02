package com.backend.pricing.price.application.dto;

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
public class PriceDetailsDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 2915944610242276354L;
    @NotNull
    private Long priceList;
    @NotNull
    private Integer priority;
}
