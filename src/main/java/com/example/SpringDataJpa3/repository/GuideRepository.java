package com.example.SpringDataJpa3.repository;

import com.example.SpringDataJpa3.entity.Guide;
import com.example.SpringDataJpa3.projection.GuideNameSalary;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GuideRepository extends JpaRepository<Guide, Long> {

    //@Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("select guide.name, guide.salary from Guide guide")
    List<Object[]> getNameAndSalaryOfAll();

    @Query("select sum(guide.salary) from Guide guide")
    Long calculateSumOfAllSalaries();

    //List<GuideNameSalary> findFirst3BySalaryGreaterThan(Integer salary);

    @Query(value = "select g.name, g.salary from Guide g where g.salary > :salary limit 3", nativeQuery = true)
    List<GuideNameSalary> findFirst3BySalaryGreaterThan(Integer salary);

}
