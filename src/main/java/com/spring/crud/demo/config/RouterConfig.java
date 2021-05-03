package com.spring.crud.demo.config;

import com.spring.crud.demo.handler.SuperHeroHandler;
//import com.spring.crud.demo.service.ReactiveSuperHeroService;
import lombok.AllArgsConstructor;
//import org.springdoc.core.annotations.RouterOperation;
//import org.springdoc.core.annotations.RouterOperations;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
@AllArgsConstructor
public class RouterConfig {

//    private final ReactiveSuperHeroService reactiveSuperHeroService;
//
//    @RouterOperations({ @RouterOperation(path = "/route/super-heroes", beanClass = SuperHeroHandler.class, beanMethod = "findAll"),
//            @RouterOperation(path = "/route/super-heroes/{id}", beanClass = SuperHeroHandler.class, beanMethod = "findById"),
//            @RouterOperation(path = "/route/super-heroes", beanClass = SuperHeroHandler.class, beanMethod = "save"),
//            @RouterOperation(path = "/route/super-heroes/{id}", beanClass = SuperHeroHandler.class, beanMethod = "update"),
//            @RouterOperation(path = "/route/super-heroes{id}", beanClass = SuperHeroHandler.class, beanMethod = "delete")
//    })
//    @Bean
//    public RouterFunction<ServerResponse> routerFunction() {
//
//        return SpringdocRouteBuilder.route()
//                .GET("/route/super-heroes", findAll(), findAllOpenAPI())
//                .build();
//    }
//
//
//    private HandlerFunction<ServerResponse> findAll() {
//        return req -> ServerResponse.ok().body(reactiveSuperHeroService.findAll(), SuperHero.class);
//    }
//
//
//    private Consumer<Builder> findAllOpenAPI() {
//        return ops -> ops.beanClass(ReactiveSuperHeroService.class).beanMethod("findAll");
//    }



    private final SuperHeroHandler superHeroHandler;

    @Bean
    public RouterFunction<ServerResponse> routerFunction() {

        return RouterFunctions.route()
                .GET("/route/super-heroes", superHeroHandler::findAll)
                .GET("/route/super-heroes/{id}", superHeroHandler::findById)
                .POST("/route/super-heroes", superHeroHandler::save)
                .PUT("/route/super-heroes/{id}", superHeroHandler::update)
                .DELETE("/route/super-heroes/{id}", superHeroHandler::delete)
                .build();
    }


//    @Bean
//    public RouterFunction<ServerResponse> routerFunction() {
//
//        return RouterFunctions.route(RequestPredicates.GET("/route/super-heroes"), superHeroHandler::findAll)
//                .andRoute(RequestPredicates.GET("/route/super-heroes/{id}"), superHeroHandler::findById)
//                .andRoute(RequestPredicates.POST("/route/super-heroes"), superHeroHandler::save)
//                .andRoute(RequestPredicates.PUT("/route/super-heroes/{id}"), superHeroHandler::update)
//                .andRoute(RequestPredicates.DELETE("/route/super-heroes/{id}"), superHeroHandler::delete);
//    }

}
