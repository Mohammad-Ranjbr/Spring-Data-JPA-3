package com.example.SpringDataJpa3.client;

import com.example.SpringDataJpa3.entity.Student;
import com.example.SpringDataJpa3.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class StudentClient implements ApplicationRunner {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentClient(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @Override
    public void run(ApplicationArguments args) {
        Student student = new Student("Mohammad Ranjbar", "99111303");
        studentRepository.save(student);
    }

}
