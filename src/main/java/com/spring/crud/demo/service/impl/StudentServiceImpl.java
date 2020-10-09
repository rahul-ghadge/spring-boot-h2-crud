package com.spring.crud.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.spring.crud.demo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.crud.demo.repository.StudentRepository;
import com.spring.crud.demo.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	

	@Autowired
	private StudentRepository repository;
	

	
	@Override
	public List<Student> getAll() {
		return repository.findAll();
	}
	
	@Override
	public Student getStudentByLastName(String lastName) {
		
		List<Student> students = repository.findAll();
		
		for (Student emp : students) {
			if (emp.getLastName().equalsIgnoreCase(lastName))
				return emp;
		}
		return Student.builder().rollNo(0).firstName("Not Found").lastName("Please enter valid id").marks(0f).build();
	}

	@Override
	public Student getStudentById(int empId) {
		List<Student> students = repository.findAll();
		for (Student emp : students) {
			if (empId == emp.getRollNo())
				return emp;
		}
		return Student.builder().rollNo(0).firstName("Not Found").lastName("Please enter valid id").marks(0f).build();
	}

	@Override
	public List<Student> getStudentByFirstName(String firstName) {
		List<Student> students = new ArrayList<>();
		List<Student> list = repository.findAll();
		for (Student emp : list) {
			if (emp.getFirstName().equalsIgnoreCase(firstName))
				students.add(emp);
		}
		return students;
	}

	@Override
	public Student getOneStudentByFirstName(String firstName) {
		return repository.findByFirstName(firstName);
	}

	@Override
	public List<Student> getStudentByFirstNameLike(String firstName) {
		return repository.findByFirstNameLike(firstName);
	}

//	@Override
//	public Student getStudentByFirstName(Student student) {
//		List<Student> list = repository.findAll();
//		for (Student emp : list) {
//			if (emp.getFirstName().equals(student.getFirstName()))
//				return emp;
//		}
//		return Student.builder().empId(0).firstName("Not Found").lastName("Please enter valid id").salary(0f).build();
//	}
//
//	@Override
//	public List<Student> getStudentByFrName(Student student) {
//		List<Student> students = new ArrayList<>();
//
//		if (null != student && null != student.getFirstName()
//				&& !(student.getFirstName().equals(""))) {
//			List<Student> list = repository.findAll();
//
//			for (Student emp : list) {
//				if (emp.getFirstName().toLowerCase().contains(student.getFirstName().toLowerCase())) {
//					students.add(emp);
//				}
//			}
//		}
//		return students;
//	}

	@Override
	public List<Student> getStudentBySalaryGreaterThan(int salary) {
		List<Student> students = new ArrayList<>();

		if (salary > 0) {
			List<Student> list = repository.findAll();

			for (Student emp : list) {
				if (emp.getMarks() > salary)
					students.add(emp);
			}
		}
		return students;
	}

	
	
	
	@Override
	public List<Student> getStudentByCondition(Student student) {
		List<Student> list = repository.findAll();
		List<Student> students = new ArrayList<>();

		// This will return true if student object is present(not null) any one of
		// property is not null OR greater than 0
		if (null != student && (null != student.getFirstName() || student.getRollNo() > 0
				|| null != student.getLastName() || student.getMarks() > 0)) {

			for (Student emp : list) {

				// If all 4 properties are present then only this block will execute
				if (null != student.getFirstName() && student.getRollNo() > 0 && null != student.getLastName()
						&& student.getMarks() > 0) {

					if (emp.getRollNo() == student.getRollNo()
							&& emp.getFirstName().equalsIgnoreCase(student.getFirstName())
							&& emp.getLastName().equalsIgnoreCase(student.getLastName())
							&& emp.getMarks() == student.getMarks()) {
						students.add(emp);
						// Break the for loop
						break;
					} else {
						// Go back to first statement
						continue;
					}
				}

				// if any one of above property is null or less than equals to 0 then below
				// block is executing
				// Emp Id
				if (student.getRollNo() == emp.getRollNo()) {
					students.add(emp);
					// Go back to first statement
					continue;
				}

				// First name
				if (null != student.getFirstName()) {
					if (emp.getFirstName().toLowerCase().contains(student.getFirstName().toLowerCase())) {
						students.add(emp);
						// Go back to first statement
						continue;
					}
				}

				// Last name
				if (null != student.getLastName()) {
					if (emp.getLastName().equalsIgnoreCase(student.getLastName()))
						students.add(emp);
					// Go back to first statement
					continue;
				}
				// salary
				if (student.getMarks() == emp.getMarks()) {
					students.add(emp);
				}
				// ---------------------------------------------------------
			}
			// returning the list
			return students;
		}
		// if below statements return false only then below list is returning
		// if (null != student &&
		// (null != student.getFirstName() || student.getEmpId() > 0
		// || null != student.getLastName() || student.getSalary() > 0))
		return students;
	}

}
