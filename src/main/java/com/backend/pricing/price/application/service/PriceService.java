package com.backend.pricing.price.application.service;

import com.backend.pricing.common.application.port.input.ICommandUseCase;
import com.backend.pricing.common.application.port.input.IQueryUseCase;
import com.backend.pricing.price.application.port.input.PriceUseCase;
import com.backend.pricing.price.application.port.output.PriceRepositoryPort;
import com.backend.pricing.price.domain.model.Price;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
public class PriceService implements IQueryUseCase<Price, Long>,
        ICommandUseCase<Price, Long>, PriceUseCase<Price, Long> {

    private final PriceRepositoryPort repositoryPort;

    public PriceService(PriceRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }


    @Override
    public Mono<Price> getApplicablePrice(Long brandId, Long productId, LocalDateTime applicationDate) {
        return this.repositoryPort.getApplicablePrice(brandId, productId)
                .filter(price -> !applicationDate.isBefore(price.getStartDate())
                        && !applicationDate.isAfter(price.getEndDate()))
                .reduce((priceOne, priceTwo) -> priceOne.getPriority() >= priceTwo.getPriority()
                        ? priceOne : priceTwo)
                .map(register -> Price.builder()
                        .id(register.getId())
                        .brandId(register.getBrandId())
                        .productId(register.getProductId())
                        .startDate(register.getStartDate())
                        .endDate(register.getEndDate())
                        .priceList(register.getPriceList())
                        .priority(register.getPriority())
                        .price(register.getPrice())
                        .currency(register.getCurrency())
                        .build());
    }

    @Override
    public Mono<Price> save(Price object) {
        return null;
    }

    @Override
    public Mono<Price> getById(Long id) {
        return null;
    }
}

