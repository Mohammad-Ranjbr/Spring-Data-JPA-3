package com.example.SpringDataJpa3.repository;

import com.example.SpringDataJpa3.entity.Student;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Repository
public interface MYCustomRepository extends Repository<Student, Long> {

    List<Student> findAll();
    Student save(Student student);
    Optional<Student> findById(Long id);

}
