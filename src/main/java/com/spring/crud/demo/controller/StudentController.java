package com.spring.crud.demo.controller;

import java.util.List;

import com.spring.crud.demo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.spring.crud.demo.service.StudentService;

@RestController
@RequestMapping("/employee-jpa")
public class StudentController {
	
	@Autowired
	private StudentService studentService;

	@GetMapping("/say")
	public String sayHello() {
		return "Hello Spring boot";
	}
	
	@GetMapping
	public List<Student> getAll() {
		return studentService.getAll();
	}
	

	@GetMapping("/{empId}")
	public Student getEmployeeById(@PathVariable int empId ) {
		return studentService.getEmployeeById(empId);
	}
	
	@GetMapping("/firstName/{firstName}")
	public List<Student> getEmployeeByName(@PathVariable String firstName ) {
		return studentService.getEmployeeByFirstName(firstName);
	}

	// get employee by first name (equals())
	@GetMapping("/one-by-firstName/{firstName}")
	public Student getOneEmployeeByFirstName(@PathVariable String firstName) {
		return studentService.getOneEmployeeByFirstName(firstName);
	}

	// get employee by first name %LIKE%
	@GetMapping("/firstName-like/{firstName}")
	public List<Student> getEmployeeByFirstNameLike(@PathVariable String firstName) {
		return studentService.getEmployeeByFirstNameLike(firstName);
	}

	@GetMapping("/one-by-lastName/{lastName}")
	public Student getEmployeeBylName(@PathVariable String lastName) {
		return studentService.getEmployeeByLastName(lastName);
	}


	@GetMapping("/salary-greater-than/{salary}")
	public List<Student> getEmployeeBySalaryGreaterThan(@PathVariable int salary) {
		return studentService.getEmployeeBySalaryGreaterThan(salary);
	}
	
	@PostMapping("/get-by-condition")
	public List<Student> getEmployeeByCondition(@RequestBody Student student) {
		return studentService.getEmployeeByCondition(student);
	}
}




