package com.backend.pricing.common.application.port.output;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IRepositoryPort<E, I> {

    Mono<E> save(E object);

    Mono<E> getById(I id);

    Flux<E> getAll();

}
