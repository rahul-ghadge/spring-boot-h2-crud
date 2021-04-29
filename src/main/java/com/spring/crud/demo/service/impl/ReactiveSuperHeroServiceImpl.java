package com.spring.crud.demo.service.impl;

import com.spring.crud.demo.model.SuperHero;
import com.spring.crud.demo.repository.SuperHeroRepository;
import com.spring.crud.demo.service.ReactiveSuperHeroService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.List;

@Service
@Slf4j
public class ReactiveSuperHeroServiceImpl implements ReactiveSuperHeroService {

    @Autowired
    private SuperHeroRepository repository;

    @Override
    public Flux<?> findAll() {

        List<SuperHero> superHeroes = repository.findAll();

        return Flux.fromIterable(superHeroes)
                .delayElements(Duration.ofSeconds(1))
                .doOnNext(superHero -> log.info(String.valueOf(superHero)))
                .map(superHero -> superHero);
    }

    @Override
    public Mono<SuperHero> findById(int id) {
        SuperHero superHero = repository.findById(id).orElseThrow(() -> new NotFoundException("** Superhero not found for id :: " + id));
        return Mono.just(superHero);
    }

    @Override
    public Mono<SuperHero> save(SuperHero superHero) {
        superHero = repository.save(superHero);
        return Mono.just(superHero);
    }

    @Override
    public Mono<SuperHero> update(int id, SuperHero superHero) {
        repository.findById(id).orElseThrow(() -> new NotFoundException("** Superhero not found for id :: " + id));
        superHero.setId(id);
        repository.save(superHero);
        return Mono.just(superHero);
    }

    @Override
    public Mono<Void> delete(int id) {
        repository.findById(id).ifPresent(superHero -> repository.delete(superHero));
        return Mono.empty();
    }
}
