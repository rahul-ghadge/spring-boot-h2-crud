package com.spring.crud.demo.utils;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

import com.spring.crud.demo.model.emp.*;
import com.spring.crud.demo.model.emp.Employee;
import com.spring.crud.demo.model.Student;
import com.spring.crud.demo.model.SuperHero;

public class HelperUtil {

    private HelperUtil() {
    }


    public static Supplier<List<Student>> studentSupplier = () ->
            Arrays.asList(
		            Student.builder().rollNo(1).firstName("Binay").lastName("Gurung").marks(300.0f).build(),
		            Student.builder().rollNo(2).firstName("Rahul").lastName("Ghadage").marks(950.0f).build(),
		            Student.builder().rollNo(3).firstName("Sunny").lastName("Deol").marks(500.0f).build(),
		            Student.builder().rollNo(4).firstName("Salman").lastName("Khan").marks(600.0f).build(),
		            Student.builder().rollNo(5).firstName("Aamir").lastName("Khan").marks(700.0f).build(),
		            Student.builder().rollNo(6).firstName("Shahrukh").lastName("Khan").marks(800.0f).build(),
		            Student.builder().rollNo(7).firstName("Ranbir").lastName("Kapoor").marks(900.0f).build(),
		            Student.builder().rollNo(8).firstName("Ranveer").lastName("Singh").marks(800.0f).build(),
		            Student.builder().rollNo(9).firstName("Akshay").lastName("Kumar").marks(900.0f).build(),
		            Student.builder().rollNo(10).firstName("Ajay").lastName("Devgan").marks(800.0f).build()
            );



    public static Supplier<List<SuperHero>> superHeroesSupplier = () ->
            Arrays.asList(
                    SuperHero.builder().name("Wade").superName("Deadpool").profession("Street fighter").age(28).canFly(false).build(),
                    SuperHero.builder().name("Bruce").superName("Hulk").profession("Doctor").age(50).canFly(false).build(),
                    SuperHero.builder().name("Steve").superName("Captain America").profession("Solder").age(120).canFly(false).build(),
                    SuperHero.builder().name("Tony").superName("Iron Man").profession("Business man").age(45).canFly(true).build(),
                    SuperHero.builder().name("Peter").superName("Spider Man").profession("Student").age(21).canFly(true).build()
            );




	public static Supplier<List<Employee>> employeeSupplier = () -> {

		Employee rahul = Employee.builder()
				.id(1)
				.firstName("Rahul")
				.lastName("Ghadage")
				.age(28)
				.noOfChildrens(0)
				.spouse(true)
				.address(Address.builder()
						.id(1)
						.streetAddress("RS road")
						.city("Pune")
						.state("Maharashtra")
						.country("India")
						.postalCode("411018")
						.build()
				)
				.hobbies(Arrays.asList("Coding", "Reading"))
				.build();

		PhoneNumber rahulsNo = PhoneNumber.builder()
				.id(1)
				.type("Mobile")
				.number("1234567890")
				.employee(rahul)
				.build();

		rahul.setPhoneNumbers(Arrays.asList(rahulsNo));






		Employee aryan = Employee.builder()
				.id(1)
				.firstName("Aryan")
				.lastName("Ghadage")
				.age(28)
				.noOfChildrens(0)
				.spouse(true)
				.address(Address.builder()
						.id(1)
						.streetAddress("A road")
						.city("Pune")
						.state("Maharashtra")
						.country("India")
						.postalCode("411018")
						.build()
				)
				.hobbies(Arrays.asList("Dancing", "Cooking"))
				.build();

		PhoneNumber aryansNumber = PhoneNumber.builder()
				.id(1)
				.type("Mobile")
				.number("1234555555")
				.employee(aryan)
				.build();

		aryan.setPhoneNumbers(Arrays.asList(aryansNumber));


		return Arrays.asList(rahul, aryan);
	};
}
