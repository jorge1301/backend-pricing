package com.backend.pricing.product.application.mapper;

import com.backend.pricing.product.adapters.output.persistence.entity.ProductEntity;
import com.backend.pricing.product.application.dto.request.ProductRequestDTO;
import com.backend.pricing.product.application.dto.response.ProductResponseDTO;
import com.backend.pricing.product.domain.entities.Product;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product toEntity(ProductEntity entity);

    @InheritInverseConfiguration(name = "toEntity")
    ProductEntity toProduct(Product product);

    @Mapping(target = "product.code", source = "id")
    @Mapping(target = "product.description", source = "name")
    ProductResponseDTO fromProduct(Product product);

    @Mapping(target = "id", source = "product.code")
    @Mapping(target = "name", source = "product.description")
    Product fromRequest(ProductRequestDTO request);
}
