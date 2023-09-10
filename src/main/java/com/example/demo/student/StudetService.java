package com.example.demo.student;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class StudetService {
	private final StudentRepository studentRepository;

	public StudetService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	public List<Student> getStudents() {
		return this.studentRepository.findAll();
	}

	public void registerNewStudent(Student student) {
		Optional<Student> studentByEmail = this.studentRepository.findStudentByEmail(student.getEmail());
		if (studentByEmail.isPresent()) {
			throw new IllegalStateException("Email already exists");
		}
		this.studentRepository.save(student);
	}

	public void deleteStudent(Long studentID) {
		boolean doesExist = this.studentRepository.existsById(studentID);
		if (!doesExist) {
			throw new IllegalStateException("Student with ID " + studentID + " doesn\'t exist");
		}
		this.studentRepository.deleteById(studentID);

	}
}
