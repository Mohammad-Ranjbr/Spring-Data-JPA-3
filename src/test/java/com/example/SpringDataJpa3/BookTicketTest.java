package com.example.SpringDataJpa3;

import com.example.SpringDataJpa3.entity.Ticket;
import com.example.SpringDataJpa3.repository.TicketRepository;
import com.example.SpringDataJpa3.service.TicketService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.Month;

@SpringBootTest
public class BookTicketTest {

    @Autowired
    private TicketService ticketService;
    @Autowired
    private TicketRepository ticketRepository;

    @Test
    public void testBookingTicket() {
        try {
            Ticket ticket = new Ticket("Bus Stop 1", "Bus Stop 2", LocalDateTime.of(2025, Month.AUGUST, 03, 15, 00));
            ticketService.bookTicket(ticket);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            Assertions.assertThat(ticketRepository.findAll()).isNotEmpty();
        }
    }

}
