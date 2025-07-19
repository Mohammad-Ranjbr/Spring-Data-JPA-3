package com.example.SpringDataJpa3.client;

import com.example.SpringDataJpa3.entity.Student;
import com.example.SpringDataJpa3.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

//When a class like StudentClient is annotated with @Component
//Spring automatically runs this class when the application (or test) is started because it is an ApplicationRunner.
//The code you write inside run() is executed at the same time as the test.
//@SpringBootTest loads the entire application context
//When you use @SpringBootTest, Spring loads the entire application context, meaning:
//All beans are loaded (including StudentClient)
//If StudentClient is still active, its run() method is also executed, even before the tests
@Component
public class StudentClient implements ApplicationRunner {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentClient(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @Override
    public void run(ApplicationArguments args) {
        //Persisting a student
        Student student = new Student("Mohamad Ranjbar", "99111303"); // Transient state
        Student returnedStudent = studentRepository.save(student);

        //Updating a student
        returnedStudent.setName("Mohammad Ranjbar");
       Student updatedStudent =  studentRepository.save(returnedStudent);

       //Finding a student by id
        Optional<Student> optional = studentRepository.findById(returnedStudent.getId());
        if(optional.isPresent()){
            Student studentById = optional.get();
            System.out.println(studentById);
        }

        //deleting a student
        studentRepository.delete(updatedStudent);

    }

}
