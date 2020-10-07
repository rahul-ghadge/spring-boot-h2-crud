package com.spring.crud.demo.model;

import lombok.Builder;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table
public class SuperHero implements Serializable {

    @Id
    @GeneratedValue
    private int id;

    private String name;
    private String superName;
    private String profession;
    private int age;
    private boolean canFly;

    // Constructor, Getter and Setter
}