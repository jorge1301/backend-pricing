package com.backend.pricing.price.application.port.output;

import com.backend.pricing.common.application.port.output.IRepositoryPort;
import com.backend.pricing.price.infrastructure.adapter.output.database.model.PriceEntity;
import reactor.core.publisher.Flux;

public interface PriceRepositoryPort extends IRepositoryPort<PriceEntity, Long> {
    Flux<PriceEntity> getApplicablePrice(Long brandId, Long productId);

}
