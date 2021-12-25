package com.spring.crud.demo.controller;


import com.spring.crud.demo.annotation.LogObjectAfter;
import com.spring.crud.demo.annotation.LogObjectBefore;
import com.spring.crud.demo.model.SuperHero;
import com.spring.crud.demo.service.SuperHeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/super-heroes")
public class SuperHeroController {

    @Autowired
    private SuperHeroService superHeroService;

    @LogObjectAfter
    @GetMapping
    public ResponseEntity<List<?>> findAll() {
        List<?> list = superHeroService.findAll();
        return ResponseEntity.ok().body(list);
    }


    @LogObjectAfter
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable int id) {
        SuperHero superHero = superHeroService.findById(id);
        return ResponseEntity.ok().body(superHero);
    }


    @LogObjectBefore
    @LogObjectAfter
    @PostMapping
    public ResponseEntity<?> save(@RequestBody SuperHero superHero) {
        SuperHero savedSuperHero = superHeroService.save(superHero);
        
//        return ResponseEntity.ok().body(savedSuperHero);
        
        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath()
        		.path("/{id}")
        		.buildAndExpand(savedSuperHero.getId())
        		.toUri();
        return ResponseEntity.created(uri).body(savedSuperHero);
    }


    @LogObjectBefore
    @LogObjectAfter
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody SuperHero superHero) {
        SuperHero updatedSuperHero = superHeroService.update(id, superHero);
        return ResponseEntity.ok().body(updatedSuperHero);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        superHeroService.delete(id);
        return ResponseEntity.ok().body("Deleted successfully...!");
    }
}
