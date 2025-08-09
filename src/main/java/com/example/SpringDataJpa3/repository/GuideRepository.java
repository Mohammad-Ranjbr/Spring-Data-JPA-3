package com.example.SpringDataJpa3.repository;

import com.example.SpringDataJpa3.entity.Guide;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GuideRepository extends JpaRepository<Guide, Long> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("select guide.name, guide.salary from Guide guide")
    List<Object[]> getNameAndSalaryOfAll();

    @Query("select sum(guide.salary) from Guide guide")
    Long calculateSumOfAllSalaries();

}
