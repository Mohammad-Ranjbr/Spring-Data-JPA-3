package com.example.SpringDataJpa3.client;

import com.example.SpringDataJpa3.entity.Ticket;
import com.example.SpringDataJpa3.repository.TicketRepository;
import com.example.SpringDataJpa3.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.Month;

//@Component
public class DoSomeTimeConsumingTaskClient implements ApplicationRunner {

    //@Autowired
    private TicketService ticketService;

    //@Autowired
    private TicketRepository ticketRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Ticket ticket = new Ticket("Bus Stop 1", "Bus Stop 2", LocalDateTime.of(2025, Month.AUGUST, 03, 15, 00));
        ticketRepository.save(ticket);
        ticketService.doSomeTimeConsumingTask();
    }

}
