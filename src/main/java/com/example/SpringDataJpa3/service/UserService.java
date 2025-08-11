package com.example.SpringDataJpa3.service;

import com.example.SpringDataJpa3.entity.User;
import com.example.SpringDataJpa3.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void persistUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User("john", LocalDate.of(2021, Month.AUGUST, 4), "john@somewhr.com", 1, true));
        users.add(new User("jane", LocalDate.of(2019, Month.MARCH, 18), "jane@somewhrelse.com", 2, true));
        users.add(new User("nicole", LocalDate.of(2017, Month.JULY, 21), "nicole@somewhr.com", 1, false));
        users.add(new User("ravi", LocalDate.of(2018, Month.JUNE, 15), "ravi@somewhrelse.com", 1, false));
        users.add(new User("alissa", LocalDate.of(2014, Month.APRIL, 5), "alissa@somewhr.com", 2, true));
        userRepository.saveAll(users);
    }

    //In Spring, transactions are propagable (default: REQUIRED).
    //This means:
    //When a service method is executed with @Transactional, Spring opens a transaction before executing it.
    //When a Repository method is called inside this service method, the same opened transaction is used (no new transaction is created).
    //So if the Repository is also @Transactional, it will effectively just enter the same existing transaction and not create any new behavior.

    @Transactional
    public void deleteUsersByLevel() {
        Integer countOfDeletedUsers = userRepository.deleteByLevel(1);
        System.out.println(countOfDeletedUsers);
    }

    @Transactional
    public void deleteUsersInBulkByLevel() {
        Integer countOfDeletedUsersInBulk = userRepository.deleteInBulkLevel(2);
        System.out.println(countOfDeletedUsersInBulk);
    }

}
