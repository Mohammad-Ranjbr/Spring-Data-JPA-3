package com.example.SpringDataJpa3.repository;

import com.example.SpringDataJpa3.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Student findByEnrollmentId(String enrollmentId);
    List<Student> findByEnrollmentIdStartingWithAndNameLike(String enrollmentId, String namePattern);
    List<Student> findFirst2ByEnrollmentIdStartingWithAndNameLike(String enrollmentId, String namePattern);

    //@Query("select s from Student s where s.name = :name")
    List<Student> findByName(String name);

    @Query(value = "select * from student where name like %?", nativeQuery = true)
    List<Student> findByNameEndingWith(String name);

}
