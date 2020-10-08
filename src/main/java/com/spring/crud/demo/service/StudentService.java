package com.spring.crud.demo.service;


import java.util.List;

import com.spring.crud.demo.model.Student;

public interface StudentService {
	
	List<Student> getAll();

	List<Student> getEmployeeByFirstName(String firstName);

	Student getOneEmployeeByFirstName(String firstName);

	List<Student> getEmployeeByFirstNameLike(String firstName);

	Student getEmployeeById(int empId);
	
	Student getEmployeeByLastName(String lastName);

	List<Student> getEmployeeBySalaryGreaterThan(int salary);
	
	List<Student> getEmployeeByCondition(Student student);

}
