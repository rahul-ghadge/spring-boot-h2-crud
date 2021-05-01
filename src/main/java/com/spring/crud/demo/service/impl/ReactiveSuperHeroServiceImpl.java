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

    //@Autowired
    //private ReactiveSuperHeroRepository reactiveSuperHeroRepository;

    @Override
    public Flux<?> findAll() {
        //Flux<SuperHero> superHeroes = reactiveSuperHeroRepository.findAll();

        List<SuperHero> superHeroes = repository.findAll();

        return Flux.fromIterable(superHeroes)
                .delayElements(Duration.ofSeconds(1))
                .doOnNext(superHero -> log.info("*** {}", superHero))
                .map(superHero -> superHero)
                .log();     // log() to print event stream on console. Check console for event logs
    }

    @Override
    public Mono<SuperHero> findById(int id) {
        //return reactiveSuperHeroRepository.findById(id).switchIfEmpty(Mono.error(new NotFoundException("** Superhero not found for id :: " + id)));

        SuperHero superHero = repository.findById(id).orElseThrow(() -> new NotFoundException("** Superhero not found for id :: " + id));
        return Mono.just(superHero)
                .log();     // log() to print event stream on console. Check console for event logs
    }

    @Override
    public Mono<SuperHero> save(SuperHero superHero) {
        //return reactiveSuperHeroRepository.save(superHero);

        superHero = repository.save(superHero);
        return Mono.just(superHero)
                .log();     // log() to print event stream on console. Check console for event logs
    }

    @Override
    public Mono<SuperHero> update(int id, SuperHero superHero) {
        //reactiveSuperHeroRepository.findById(id).switchIfEmpty(Mono.error(new NotFoundException("** Superhero not found for id :: " + id)));

        repository.findById(id).orElseThrow(() -> new NotFoundException("** Superhero not found for id :: " + id));
        superHero.setId(id);
        return this.save(superHero);
    }

    @Override
    public Mono<Void> delete(int id) {
        //reactiveSuperHeroRepository.findById(id).doOnNext(repository::delete);

        repository.findById(id).ifPresent(repository::delete);
        return Mono.empty();
    }
}
