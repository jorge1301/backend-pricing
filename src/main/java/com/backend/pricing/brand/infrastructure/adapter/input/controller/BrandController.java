package com.backend.pricing.brand.infrastructure.adapter.input.controller;


import com.backend.pricing.brand.application.service.BrandService;
import com.backend.pricing.brand.domain.model.Brand;
import com.backend.pricing.brand.infrastructure.adapter.input.dto.BrandRequest;
import com.backend.pricing.brand.infrastructure.adapter.input.dto.BrandResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/brand")
@RequiredArgsConstructor
public class BrandController {

    private final BrandService brandService;


    @PostMapping
    public Mono<BrandResponse> createBrand(@RequestBody BrandRequest request) {
        Brand brand = Brand.builder()
                .id(request.getId())
                .name(request.getName())
                .build();

        return brandService.save(brand)
                .map(createdBrand -> BrandResponse.builder()
                        .id(createdBrand.getId())
                        .name(createdBrand.getName())
                        .build());
    }
}
