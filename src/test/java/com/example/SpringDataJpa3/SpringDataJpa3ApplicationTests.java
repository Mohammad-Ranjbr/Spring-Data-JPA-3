package com.example.SpringDataJpa3;

import com.example.SpringDataJpa3.entity.Student;
import com.example.SpringDataJpa3.repository.StudentRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest // This annotation causes the entire Spring Boot application context to be loaded.
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
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

	@Test
	public void testFindByEnrollmentId(){
		Student student = studentRepository.findByEnrollmentId("991113031");
		Assertions.assertEquals("991113031", student.getEnrollmentId());
		System.out.println(student);
	}

	@Test
	public void testFindByEnrollmentIdStartingWithAndNameLike(){
		List<Student> students = studentRepository.findByEnrollmentIdStartingWithAndNameLike("99111", "H%");
		Assertions.assertEquals(3, students.size());
		System.out.println(students);
	}

	@Test
	public void testFindFirst2ByEnrollmentIdStartingWithAndNameLike(){
		List<Student> students = studentRepository.findFirst2ByEnrollmentIdStartingWithAndNameLike("99111", "H%");
		Assertions.assertEquals(2, students.size());
		System.out.println(students);
	}

	@Test
	public void testFindByName(){
		List<Student> students = studentRepository.findByName("Mohamad Ranjbar");
		Assertions.assertEquals("Mohamad Ranjbar", students.get(0).getName());
		System.out.println(students);
	}

	@Test
	public void testFindByNameEndingWith(){
		List<Student> students = studentRepository.findByNameEndingWith("Ranjbar");
		Assertions.assertEquals(7, students.size());
		System.out.println(students);
	}

	@BeforeAll
	public void populateData(){
		List<Student> students = new ArrayList<>();
		students.add(new Student("Mohamad Ranjbar", "991113031"));
		students.add(new Student("Hossein Ranjbar", "991113032"));
		students.add(new Student("Hamid Ranjbar", "991113033"));
		students.add(new Student("Fatemeh Ranjbar", "991113034"));
		students.add(new Student("Abas Ranjbar", "991113035"));
		students.add(new Student("Asghar Ranjbar", "991113036"));
		students.add(new Student("Hasan Ranjbar", "991113037"));
		studentRepository.saveAll(students);
	}

	@AfterAll
	public void dePopulateData(){
		studentRepository.deleteAll();
	}

}
