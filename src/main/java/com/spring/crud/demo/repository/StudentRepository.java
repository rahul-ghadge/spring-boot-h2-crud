package com.spring.crud.demo.repository;

import com.spring.crud.demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    Student findByFirstName(String firstName);

    List<Student> findByFirstNameLike(String firstName);


}
