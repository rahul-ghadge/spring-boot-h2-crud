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
    public ResponseEntity<?> findById(@PathVariable int id) {
        Mono<SuperHero> superHero = reactiveSuperHeroService.findById(id);
        return ResponseEntity.ok().body(superHero);
    }


    @PostMapping
    public ResponseEntity<?> save(@RequestBody SuperHero superHero) {
        Mono<SuperHero> savedSuperHero = reactiveSuperHeroService.save(superHero);
        return ResponseEntity.ok().body(savedSuperHero);
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody SuperHero superHero) {
        Mono<SuperHero> updatedSuperHero = reactiveSuperHeroService.update(id, superHero);
        return ResponseEntity.ok().body(updatedSuperHero);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        Mono<Void> monoVoid = reactiveSuperHeroService.delete(id);
        return ResponseEntity.ok().body("Deleted successfully...!");
    }
}
