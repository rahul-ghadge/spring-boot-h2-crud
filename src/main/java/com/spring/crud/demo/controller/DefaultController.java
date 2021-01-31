package com.spring.crud.demo.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
public class DefaultController {


    @Operation(summary = "Swagger documentation url", hidden = true)
    @GetMapping
    ResponseEntity<Void> redirect() {
        return ResponseEntity.status(HttpStatus.FOUND)
                .location(URI.create("swagger-ui-custom.html"))
                .build();
    }

    @Operation(summary = "Database url", hidden = true)
    @GetMapping("/database")
    public ResponseEntity<Void> databaseUrl() {
        return ResponseEntity.status(HttpStatus.FOUND)
                .location(URI.create("h2-console"))
                .build();

    }

}
