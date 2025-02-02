package com.backend.pricing.brand.application.service;

import com.backend.pricing.brand.application.dto.BrandDTO;
import com.backend.pricing.brand.application.dto.request.BrandRequestDTO;
import com.backend.pricing.brand.application.dto.response.BrandResponseDTO;
import com.backend.pricing.brand.application.mapper.BrandMapper;
import com.backend.pricing.brand.application.port.output.BrandRepositoryPort;
import com.backend.pricing.brand.domain.entities.Brand;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class BrandServiceTest {

    @InjectMocks
    private BrandService service;

    @Mock
    private BrandRepositoryPort repositoryPort;

    @Mock
    private BrandMapper mapper;

    private static BrandRequestDTO requestDTO;
    private static BrandResponseDTO responseDTO;
    private static Brand brand;

    @BeforeAll
    static void setup() {
        requestDTO = BrandRequestDTO.builder()
                .brand(BrandDTO.builder()
                        .code(1L)
                        .description("Test Brand")
                        .build())
                .build();

        brand = new Brand(1L, "Test Brand");
        responseDTO = BrandResponseDTO.builder()
                .brand(BrandDTO.builder()
                        .code(1L)
                        .description("Test Brand").build())
                .build();
    }

    @Test
    void saveBrandTest() {
        doReturn(brand).when(this.mapper).fromRequest(any(BrandRequestDTO.class));
        doReturn(responseDTO).when(this.mapper).fromBrand(any(Brand.class));
        doReturn(Mono.just(brand)).when(this.repositoryPort).save(any());
        Mono<BrandResponseDTO> resultMono = this.service.saveBrand(requestDTO);
        StepVerifier.create(resultMono)
                .expectNext(responseDTO)
                .verifyComplete();
    }


    @Test
    void getBrandTestWithId() {
        doReturn(responseDTO).when(this.mapper).fromBrand(any(Brand.class));
        doReturn(Mono.just(brand)).when(this.repositoryPort).getById(any());
        Flux<BrandResponseDTO> resultMono = this.service.getBrand(1L);
        StepVerifier.create(resultMono)
                .expectNext(responseDTO)
                .verifyComplete();
    }

    @Test
    void getBrandTestWithoutId() {
        doReturn(responseDTO).when(this.mapper).fromBrand(any(Brand.class));
        doReturn(Flux.just(brand)).when(this.repositoryPort).getAll();
        Flux<BrandResponseDTO> resultMono = this.service.getBrand(null);
        StepVerifier.create(resultMono)
                .expectNext(responseDTO)
                .verifyComplete();
    }
}