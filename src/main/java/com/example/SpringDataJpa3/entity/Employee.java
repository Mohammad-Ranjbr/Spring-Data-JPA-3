package com.example.SpringDataJpa3.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   private String username;
   private String firstName;
   private String lastName;
   private String email;
   private int level;

    public Employee(String username, String firstName, String lastName, String email, int level) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.level = level;
    }
}
