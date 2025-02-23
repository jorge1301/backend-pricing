package com.backend.pricing.brand.adapters.input.controller;


import com.backend.pricing.brand.application.dto.request.BrandRequestDTO;
import com.backend.pricing.brand.application.dto.response.BrandResponseDTO;
import com.backend.pricing.brand.application.service.BrandService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/brand")
@RequiredArgsConstructor
public class BrandController {
    private final BrandService brandService;

    @PostMapping
    public Mono<ResponseEntity<BrandResponseDTO>> createBrand(@Valid @RequestBody BrandRequestDTO request) {
        return this.brandService.saveBrand(request).map(ResponseEntity::ok);
    }

    @GetMapping
    public Flux<ResponseEntity<BrandResponseDTO>> getBrand(@RequestParam(value = "code", required = false) Long id) {
        return this.brandService.getBrand(id).map(ResponseEntity::ok);
    }
}
