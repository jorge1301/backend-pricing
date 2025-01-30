package com.backend.pricing.common.application.port.input;

import reactor.core.publisher.Mono;

public interface ICommandUseCase<E, I> {
    Mono<E> save(E object);
}
