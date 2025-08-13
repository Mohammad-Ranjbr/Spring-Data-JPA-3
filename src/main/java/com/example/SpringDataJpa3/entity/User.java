package com.example.SpringDataJpa3.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    @Column(name = "registration_date")
    private LocalDate registrationDate;

    private String email;
    private Integer level;

    @Column(name = "active")
    private Boolean isActive;

    @Version
    private Integer version;

    public User(String username, LocalDate registrationDate, String email, Integer level, Boolean isActive) {
        this.username = username;
        this.registrationDate = registrationDate;
        this.email = email;
        this.level = level;
        this.isActive = isActive;
    }

    @PostRemove
    public void foo(){
        System.out.println("User[id=" + this.id + "] just got deleted");
    }

}
