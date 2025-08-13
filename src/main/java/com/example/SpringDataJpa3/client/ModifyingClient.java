package com.example.SpringDataJpa3.client;

import com.example.SpringDataJpa3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

//@Component
public class ModifyingClient implements ApplicationRunner {

    private final UserService userService;

    //@Autowired
    public ModifyingClient(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        userService.persistUsers();
        userService.deleteUsersByLevel();
        userService.deleteUsersInBulkByLevel();
    }

}
