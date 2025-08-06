package com.example.SpringDataJpa3.repository;

import com.example.SpringDataJpa3.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
