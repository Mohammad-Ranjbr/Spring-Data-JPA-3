package com.example.SpringDataJpa3.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
@Table(name = "tickets")
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String origin;
    private String destination;

    @Column(name = "scheduled_at")
    private LocalDateTime scheduledAt;

    public Ticket(String origin, String destination, LocalDateTime scheduledAt) {
        this.origin = origin;
        this.destination = destination;
        this.scheduledAt = scheduledAt;
    }

}
