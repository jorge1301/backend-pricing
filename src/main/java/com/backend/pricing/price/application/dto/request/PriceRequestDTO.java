package com.backend.pricing.price.application.dto.request;

import com.backend.pricing.brand.application.dto.BrandDTO;
import com.backend.pricing.price.application.dto.PriceDTO;
import com.backend.pricing.product.application.dto.ProductDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@Builder
public class PriceRequestDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 4231426192877801013L;

    @Valid
    @NotNull
    private BrandDTO brand;

    @Valid
    @NotNull
    private ProductDTO product;

    @Valid
    @NotNull
    private PriceDTO price;
}
