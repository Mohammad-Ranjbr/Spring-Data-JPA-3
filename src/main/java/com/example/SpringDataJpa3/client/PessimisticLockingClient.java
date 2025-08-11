package com.example.SpringDataJpa3.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Order(2)
//@Component
public class PessimisticLockingClient implements ApplicationRunner {

    private final UserXClient userXClient;
    private final UserYClient userYClient;

    //@Autowired
    public PessimisticLockingClient(UserXClient userXClient, UserYClient userYClient) {
        this.userXClient = userXClient;
        this.userYClient = userYClient;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(userXClient);
        executor.execute(userYClient);
        executor.shutdown();
    }

}
