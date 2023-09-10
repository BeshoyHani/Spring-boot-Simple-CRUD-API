package com.example.demo.student;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {
	@Bean
	CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
		return args -> {
			Student s1 = new Student("Beshoy Hani", "be4oy.hani@gmail.com", LocalDate.of(2000, 3, 26));
			Student s2 = new Student("David Maged", "david@gmail.com", LocalDate.of(2000, 7, 15));

			studentRepository.saveAll(List.of(s1, s2));
		};
	}
}
