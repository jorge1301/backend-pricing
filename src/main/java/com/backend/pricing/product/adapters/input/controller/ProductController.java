package com.backend.pricing.product.adapters.input.controller;


import com.backend.pricing.product.application.dto.request.ProductRequestDTO;
import com.backend.pricing.product.application.dto.response.ProductResponseDTO;
import com.backend.pricing.product.application.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public Mono<ProductResponseDTO> createProduct(@RequestBody ProductRequestDTO request) {
        return this.productService.saveProduct(request);
    }

    @GetMapping
    public Flux<ProductResponseDTO> getProduct(@RequestParam(value = "code", required = false) Long id) {
        return this.productService.getProduct(id);
    }
}
