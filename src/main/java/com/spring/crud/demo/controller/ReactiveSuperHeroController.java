package com.spring.crud.demo.controller;

import com.spring.crud.demo.model.SuperHero;
import com.spring.crud.demo.service.ReactiveSuperHeroService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/reactive/super-heroes")
public class ReactiveSuperHeroController {

    @Autowired
    private ReactiveSuperHeroService reactiveSuperHeroService;

    @Operation(summary = "Try this endpoint in chrome, postman doesn't support for reactive programming")
    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public ResponseEntity<Flux<?>> findAll() {
        Flux<?> list = reactiveSuperHeroService.findAll();
        return ResponseEntity.ok().body(list);
    }


    @GetMapping("/{id}")
    public Mono<?> findById(@PathVariable int id) {
        return reactiveSuperHeroService.findById(id);
    }


    @PostMapping
    public Mono<?> save(@RequestBody SuperHero superHero) {
        return reactiveSuperHeroService.save(superHero);
    }


    @PutMapping("/{id}")
    public Mono<?> update(@PathVariable int id, @RequestBody SuperHero superHero) {
        return reactiveSuperHeroService.update(id, superHero);
    }


    @DeleteMapping("/{id}")
    public Mono<?> delete(@PathVariable int id) {
        Mono<Void> monoVoid = reactiveSuperHeroService.delete(id);
        return Mono.just("Deleted successfully...!");
    }
}
