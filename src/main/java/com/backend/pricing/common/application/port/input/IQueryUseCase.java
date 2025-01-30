package com.backend.pricing.common.application.port.input;

import reactor.core.publisher.Mono;

public interface IQueryUseCase<E, I> {
    Mono<E> getById(I id);
}
