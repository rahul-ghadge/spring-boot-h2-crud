package com.spring.crud.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.crud.demo.model.Employee;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, String> {

    Employee findByFirstName(String firstName);

    List<Employee> findByFirstNameLike(String firstName);


}
