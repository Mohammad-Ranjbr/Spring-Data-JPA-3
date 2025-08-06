package com.example.SpringDataJpa3.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
    @Column(name = "creation_date")
    private LocalDate creationDate;
    private Integer price;

    public Item(String name, LocalDate creationDate, Integer price) {
        this.name = name;
        this.creationDate = creationDate;
        this.price = price;
    }

}
