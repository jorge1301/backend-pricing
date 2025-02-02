package com.backend.pricing.price.application.service;

import com.backend.pricing.common.exception.ConflictException;
import com.backend.pricing.price.application.dto.request.PriceRequestDTO;
import com.backend.pricing.price.application.dto.response.PriceResponseDTO;
import com.backend.pricing.price.application.mapper.PriceMapper;
import com.backend.pricing.price.application.port.input.PriceUseCase;
import com.backend.pricing.price.application.port.output.BrandFetcherPort;
import com.backend.pricing.price.application.port.output.PriceRepositoryPort;
import com.backend.pricing.price.application.port.output.ProductFetcherPort;
import com.backend.pricing.price.domain.entities.Price;
import com.backend.pricing.price.domain.service.PriceValidationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PriceService implements PriceUseCase {

    private final PriceRepositoryPort repositoryPort;
    private final BrandFetcherPort brandFetcherPort;
    private final ProductFetcherPort productFetcherPort;
    private final PriceValidationService validationService;
    private final PriceMapper mapper;

    @Override
    public Mono<PriceResponseDTO> getApplicablePrice(Long brandId, Long productId, LocalDateTime applicationDate) {
        return this.repositoryPort.getApplicablePrice(brandId, productId)
                .filter(price -> !applicationDate.isBefore(price.getStartDate())
                        && !applicationDate.isAfter(price.getEndDate()))
                .reduce((priceOne, priceTwo) -> priceOne.getPriority() >= priceTwo.getPriority()
                        ? priceOne : priceTwo)
                .flatMap(this::getProductAndBrandNames);
    }

    @Override
    public Mono<PriceResponseDTO> savePrice(PriceRequestDTO request) {
        Price price = this.mapper.fromRequest(request);
        this.validationService.validatePrice(price);
        return this.repositoryPort.existsPrice(price.getBrandId(),
                        price.getProductId(), price.getStartDate())
                .flatMap(exits -> {
                    if (exits) {
                        return Mono.error(new ConflictException("The price already exists"));
                    } else {
                        return this.repositoryPort.save(price)
                                .flatMap(this::getProductAndBrandNames);
                    }
                });
    }

    @Override
    public Flux<PriceResponseDTO> getPrice(Long id) {
        if (id == null) {
            return this.repositoryPort.getAll().flatMap(this::getProductAndBrandNames);
        } else {
            return this.repositoryPort.getById(id).flatMap(this::getProductAndBrandNames).flux();
        }
    }

    private Mono<PriceResponseDTO> getProductAndBrandNames(Price price) {
        return this.productFetcherPort.fetchProductById(price.getProductId())
                .zipWith(this.brandFetcherPort.fetchBrandById(price.getBrandId()))
                .map(tuple -> {
                    return this.mapper.fromPrice(price, tuple.getT1(), tuple.getT2());
                });
    }
}

