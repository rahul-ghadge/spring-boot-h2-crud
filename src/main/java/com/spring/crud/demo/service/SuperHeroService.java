package com.spring.crud.demo.service;

import com.spring.crud.demo.model.SuperHero;

import java.util.List;

public interface SuperHeroService {

    List<?> findAll();

    SuperHero findById(int id);

    SuperHero save(SuperHero superHero);

    SuperHero update(int id, SuperHero superHero);

    void delete(int id);
}
