package com.backend.pricing.product.application.port.output;

import com.backend.pricing.common.application.port.output.IRepositoryPort;
import com.backend.pricing.product.domain.entities.Product;

public interface ProductRepositoryPort extends IRepositoryPort<Product, Long> {
}
