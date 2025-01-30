package com.backend.pricing.price.infrastructure.adapter.output;

import com.backend.pricing.common.application.port.output.IRepositoryPort;
import com.backend.pricing.price.application.port.output.PriceRepositoryPort;
import com.backend.pricing.price.infrastructure.adapter.output.database.model.PriceEntity;
import com.backend.pricing.price.infrastructure.adapter.output.database.repository.PriceR2dbcRepository;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Component
public class PriceRepositoryAdapter implements IRepositoryPort<PriceEntity, Long>,
        PriceRepositoryPort {

    private final PriceR2dbcRepository repository;

    public PriceRepositoryAdapter(PriceR2dbcRepository repository) {
        this.repository = repository;
    }
//
//    @Override
//    public Mono<Price> save(Price price) {
//        PriceEntity entity = PriceEntity.builder()
//                .id(PriceIdEntity.builder()
//                        .productId(price.getId().getProductId())
//                        .brandId(price.getId().getBrandId())
//                        .startDate(price.getId().getStartDate())
//                        .build())
//                .price(price.getPrice())
//                .currency(price.getCurrency())
//                .endDate(price.getEndDate())
//                .priceList(price.getPriceList())
//                .priority(price.getPriority())
//                .build();
//
//        return this.repository.save(entity).map(saveEntity ->
//                Price.builder()
//                        .id(PriceId.builder()
//                                .productId(saveEntity.getId().getProductId())
//                                .brandId(saveEntity.getId().getBrandId())
//                                .startDate(saveEntity.getId().getStartDate())
//                                .build())
//                        .price(saveEntity.getPrice())
//                        .currency(saveEntity.getCurrency())
//                        .endDate(saveEntity.getEndDate())
//                        .priceList(saveEntity.getPriceList())
//                        .priority(saveEntity.getPriority())
//                        .build());
//    }
//
//    @Override
//    public Mono<Price> getById(PriceId id) {
//        return this.repository.findById(PriceIdEntity.builder().build());
//    }

    @Override
    public Flux<PriceEntity> getApplicablePrice(Long brandId, Long productId) {
        return this.repository.findByBrandIdAndProductId(brandId, productId);
    }

    @Override
    public Mono<PriceEntity> save(PriceEntity object) {
        return null;
    }

    @Override
    public Mono<PriceEntity> getById(Long id) {
        return null;
    }
}
