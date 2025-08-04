package com.example.SpringDataJpa3.service;

import com.example.SpringDataJpa3.entity.Ticket;
import com.example.SpringDataJpa3.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;

    @Autowired
    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    //@Transactional
    @Transactional
    public void bookTicket(Ticket ticket) {
        ticketRepository.save(ticket);
        //throw new RuntimeException("Payment failed");
    }

    @Transactional
    public void doSomeTimeConsumingTask() throws InterruptedException {
        Thread.sleep(40000);
        Ticket ticket = ticketRepository.findById(1L).get();
        Thread.sleep(40000);
    }

}
