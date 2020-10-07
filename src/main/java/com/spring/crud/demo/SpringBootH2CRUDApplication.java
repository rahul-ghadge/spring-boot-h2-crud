package com.spring.crud.demo;

import com.spring.crud.demo.model.Employee;
import com.spring.crud.demo.model.SuperHero;
import com.spring.crud.demo.repository.EmployeeRepository;
import com.spring.crud.demo.repository.SuperHeroRepository;
import com.spring.crud.demo.utils.HelperUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;


@Slf4j
@SpringBootApplication
@EnableJpaRepositories
public class SpringBootH2CRUDApplication {

	//private final Logger log = LoggerFactory.getLogger(getClass());

	public static void main(String[] args) {
		SpringApplication.run(SpringBootH2CRUDApplication.class, args);
	}



	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private SuperHeroRepository superHeroRepository;

	
	@Bean
	CommandLineRunner runner() {
		return args -> {
			List<Employee> employees = employeeRepository.findAll();
				if (employees.size() == 0) {
					log.info("******* Inserting Employees to DB *******");
					employeeRepository.saveAll(HelperUtil.employeeSupplier.get());
				} else {
					log.info("******* Employees stored in DB Size :: {}", employees.size());
					log.info("******* Employees stored in DB :: {}", employees);
				}

			List<SuperHero> superHeroes = superHeroRepository.findAll();
			if (superHeroes.size() == 0) {
				log.info("******* Inserting Super heroes to DB *******");
				superHeroRepository.saveAll(HelperUtil.superHeroesSupplier.get());
			} else {
				log.info("******* Super heroes stored in DB Size :: {}", superHeroes.size());
				log.info("******* Super heroes stored in DB :: {}", superHeroes);
			}
		};
	}

}
