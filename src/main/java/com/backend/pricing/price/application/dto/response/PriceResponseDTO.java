package com.backend.pricing.price.application.dto.response;

import com.backend.pricing.brand.application.dto.BrandDTO;
import com.backend.pricing.price.application.dto.PriceDTO;
import com.backend.pricing.product.application.dto.ProductDTO;
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
public class PriceResponseDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = -2072957596443514497L;
    private BrandDTO brand;
    private ProductDTO product;
    private PriceDTO price;
}
