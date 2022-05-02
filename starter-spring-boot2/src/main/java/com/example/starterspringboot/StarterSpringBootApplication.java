package com.example.starterspringboot;

import com.example.starterspringboot.domians.Employee;
import com.example.starterspringboot.repositorys.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StarterSpringBootApplication {

	@Bean //mock data เริ่มต้น
	public CommandLineRunner init(EmployeeRepository employeeRepository){
		return (args -> {
			employeeRepository.save(new Employee("John", "Want"));
			employeeRepository.save(new Employee("Champ", "Evil"));
			employeeRepository.save(new Employee("Jame", "Wild"));
			employeeRepository.save(new Employee("Hope", "Worm"));
		});
	}

	public static void main(String[] args) {
		SpringApplication.run(StarterSpringBootApplication.class, args);
	}

}
