package com.example.SpringDataJpa3.repository;

import com.example.SpringDataJpa3.entity.Log;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogRepository extends JpaRepository<Log, Long> {
}
