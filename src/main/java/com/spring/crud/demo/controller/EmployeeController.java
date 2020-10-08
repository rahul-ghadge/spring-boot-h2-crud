package com.spring.crud.demo.controller;

import com.spring.crud.demo.model.emp.Employee;
import com.spring.crud.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @GetMapping
    public ResponseEntity<List<?>> findAll() {
        List<?> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable int id) {
        Employee employee = service.findById(id);
        return ResponseEntity.ok().body(employee);
    }


    @PostMapping
    public ResponseEntity<?> save(@RequestBody Employee employee) {
        Employee savedEmployee = service.save(employee);
        return ResponseEntity.ok().body(savedEmployee);
    }


    @PutMapping
    public ResponseEntity<?> update(@RequestBody Employee employee) {
        Employee updatedEmployee = service.update(employee);
        return ResponseEntity.ok().body(updatedEmployee);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        service.delete(id);
        return ResponseEntity.ok().body("Deleted successfully...!");
    }
}

