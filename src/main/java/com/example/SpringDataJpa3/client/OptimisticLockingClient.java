package com.example.SpringDataJpa3.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Order(2) //The order in which they are executed is determined by Spring Boot at application startup time.
@Component
public class OptimisticLockingClient implements ApplicationRunner {

    private final User1Client user1Client;
    private final User2Client user2Client;

    @Autowired
    public OptimisticLockingClient(User1Client user1Client, User2Client user2Client) {
        this.user1Client = user1Client;
        this.user2Client = user2Client;
    }

    //Two operations are concurrent using a thread pool.
    //This line creates a pool of threads that:
    //A maximum of 2 threads can be active in it at the same time.
    //It is created using Executors.newFixedThreadPool(2).
    //The output is an ExecutorService that is used to manage the execution of concurrent tasks.
    //That is, it can execute two Runnables at the same time.
    //This line causes user1Client (which is a Runnable class) to be executed by one of the threads in the pool.
    //The run() method inside user1Client will be executed.
    //Do not accept any new tasks.
    //But execute the running or queued tasks to the end.
    //Then shut down itself.
    //Note: shutdown() does not immediately close the threads, it just does not allow new tasks to be executed.

    @Override
    public void run(ApplicationArguments args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(user1Client);
        executor.execute(user2Client);
        executor.shutdown();
    }

}
