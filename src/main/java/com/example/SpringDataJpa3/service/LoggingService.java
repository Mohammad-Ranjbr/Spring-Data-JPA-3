package com.example.SpringDataJpa3.service;

import com.example.SpringDataJpa3.entity.Log;
import com.example.SpringDataJpa3.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
public class LoggingService {

    private final LogRepository logRepository;

    @Autowired
    public LoggingService(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void logAMessage(String message) {
        Log log = new Log(LocalDate.of(2025, 5, 1), message);
        logRepository.save(log);

        //throw new RuntimeException("DummyException: this should cause rollback of both INSERTs (Item and Log)!");
    }

}
