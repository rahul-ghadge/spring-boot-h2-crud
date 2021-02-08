package com.spring.crud.demo.service.impl;

import com.spring.crud.demo.model.SuperHero;
import com.spring.crud.demo.repository.SuperHeroRepository;
import com.spring.crud.demo.service.SuperHeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;

@Service
public class SuperHeroServiceImpl implements SuperHeroService {

    @Autowired
    private SuperHeroRepository repository;

    @Override
    public List<SuperHero> findAll() {
        return repository.findAll();
    }

    @Override
    public SuperHero findById(int id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("** Superhero not found for id :: " + id));
    }

    @Override
    public SuperHero save(SuperHero superHero) {
        return repository.save(superHero);
    }

    @Override
    public SuperHero update(int id, SuperHero superHero) {
    	repository.findById(id).orElseThrow(() -> new NotFoundException("** Superhero not found for id :: " + id));
    	superHero.setId(id);
        return repository.save(superHero);
    }

    @Override
    public void delete(int id) {
       repository.findById(id).ifPresent(superHero -> repository.delete(superHero));
    }
}
