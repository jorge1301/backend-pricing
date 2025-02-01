package com.backend.pricing.price.application.mapper;

import com.backend.pricing.brand.domain.entities.Brand;
import com.backend.pricing.price.adapters.output.persistence.entity.PriceEntity;
import com.backend.pricing.price.application.dto.request.PriceRequestDTO;
import com.backend.pricing.price.application.dto.response.PriceResponseDTO;
import com.backend.pricing.price.domain.entities.Price;
import com.backend.pricing.product.domain.entities.Product;
import org.mapstruct.Builder;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface PriceMapper {
    Price toEntity(PriceEntity entity);

    @InheritInverseConfiguration(name = "toEntity")
    PriceEntity toPrice(Price price);

    @Mapping(target = "product.code", source = "price.productId")
    @Mapping(target = "product.description", source = "product.name")
    @Mapping(target = "price.period.startDate", source = "price.startDate")
    @Mapping(target = "price.period.endDate", source = "price.endDate")
    @Mapping(target = "price.details.priceList", source = "price.priceList")
    @Mapping(target = "price.details.priority", source = "price.priority")
    @Mapping(target = "brand.code", source = "price.brandId")
    @Mapping(target = "brand.description", source = "brand.name")
    @Mapping(target = "price.amount.price", source = "price.price")
    @Mapping(target = "price.amount.currency", source = "price.currency")
    PriceResponseDTO fromPrice(Price price, Product product, Brand brand);


    @Mapping(target = "id", ignore = true)
    @Mapping(target = "brandId", source = "brand.code")
    @Mapping(target = "productId", source = "product.code")
    @Mapping(target = "priority", source = "price.details.priority")
    @Mapping(target = "priceList", source = "price.details.priceList")
    @Mapping(target = "startDate", source = "price.period.startDate")
    @Mapping(target = "endDate", source = "price.period.endDate")
    @Mapping(target = "price", source = "price.amount.price")
    @Mapping(target = "currency", source = "price.amount.currency")
    Price fromRequest(PriceRequestDTO request);
}
