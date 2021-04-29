package com.spring.crud.demo.service;

import com.spring.crud.demo.model.SuperHero;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ReactiveSuperHeroService {

    Flux<?> findAll();

    Mono<SuperHero> findById(int id);

    Mono<SuperHero> save(SuperHero superHero);

    Mono<SuperHero> update(int id, SuperHero superHero);

    Mono<Void> delete(int id);
}
