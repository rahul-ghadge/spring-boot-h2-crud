package com.spring.crud.demo.repository;

import com.spring.crud.demo.model.SuperHero;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SuperHeroRepository extends JpaRepository<SuperHero, Integer> {

}
