package com.spring.crud.demo.handler;


import com.spring.crud.demo.model.SuperHero;
import com.spring.crud.demo.service.ReactiveSuperHeroService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class SuperHeroHandler {

    private final ReactiveSuperHeroService reactiveSuperHeroService;


    public Mono<ServerResponse> findAll(ServerRequest serverRequest) {
        Flux<?> list = reactiveSuperHeroService.findAll();
        return ServerResponse.ok()
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .body(list, SuperHero.class);
    }


    public Mono<ServerResponse> findById(ServerRequest serverRequest) {
        int id = Integer.parseInt(serverRequest.pathVariable("id"));
        Mono<SuperHero> superHeroMono = reactiveSuperHeroService.findById(id);
        return ServerResponse.ok().body(superHeroMono, SuperHero.class);
    }


    public Mono<ServerResponse> save(ServerRequest serverRequest) {
        Mono<SuperHero> superHero = serverRequest.bodyToMono(SuperHero.class);
        Mono<SuperHero> superHeroMono = reactiveSuperHeroService.save(superHero.block());
        return ServerResponse.ok().body(superHeroMono, SuperHero.class);
    }


    public Mono<ServerResponse> update(ServerRequest serverRequest) {
        int id = Integer.parseInt(serverRequest.pathVariable("id"));
        Mono<SuperHero> superHero = serverRequest.bodyToMono(SuperHero.class);
        Mono<SuperHero> superHeroMono = reactiveSuperHeroService.update(id, superHero.block());
        return ServerResponse.ok().body(superHeroMono, SuperHero.class);
    }


    public Mono<ServerResponse> delete(ServerRequest serverRequest) {
        int id = Integer.parseInt(serverRequest.pathVariable("id"));
        Mono<Void> superHeroMono = reactiveSuperHeroService.delete(id);
        return ServerResponse.ok().body("Deleted successfully...!", String.class);
    }

}
