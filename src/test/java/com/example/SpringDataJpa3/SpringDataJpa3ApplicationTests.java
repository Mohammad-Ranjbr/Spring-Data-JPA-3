package com.example.SpringDataJpa3;

import com.example.SpringDataJpa3.entity.Student;
import com.example.SpringDataJpa3.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest // This annotation causes the entire Spring Boot application context to be loaded.
class SpringDataJpa3ApplicationTests {

	@Autowired
	private StudentRepository studentRepository;

	@Test
	public void testCrud(){
		//Create
		Student student = new Student("Mohamad Ranjbar", "991113031");
		Student returnedStudent = studentRepository.save(student);
		Assertions.assertNotNull(returnedStudent.getId());

		//Update
		returnedStudent.setName("Mohammad Ranjbar");
		Student updatedStudent = studentRepository.save(returnedStudent);
		Assertions.assertEquals("Mohammad Ranjbar", updatedStudent.getName());

		//Read
		Student foundStudent = studentRepository.findById(returnedStudent.getId()).get();
		Assertions.assertEquals(1L, foundStudent.getId());

		//Delete
		studentRepository.delete(foundStudent);
		Assertions.assertFalse(studentRepository.existsById(foundStudent.getId()));
	}

	@Test
	public void testMyCustomRepository(){
		//save
		Student student = new Student("Mohamad Ranjbar", "991113031");
		Student returnedStudent = studentRepository.save(student);
		Assertions.assertNotNull(returnedStudent.getId());

		//findById
		Student foundStudent = studentRepository.findById(returnedStudent.getId()).get();
		Assertions.assertEquals(1L, foundStudent.getId());

		//findAll
		List<Student> returnedStudents = studentRepository.findAll();
		Assertions.assertEquals(1, returnedStudents.size());
	}

}
