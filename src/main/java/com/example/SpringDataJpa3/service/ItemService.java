package com.example.SpringDataJpa3.service;

import com.example.SpringDataJpa3.entity.Item;
import com.example.SpringDataJpa3.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
public class ItemService {

    private final ItemRepository itemRepository;
    private final LoggingService loggingService;

    @Autowired
    public ItemService(ItemRepository itemRepository, LoggingService loggingService) {
        this.itemRepository = itemRepository;
        this.loggingService = loggingService;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void persistAnItem() {
        Item item = new Item("Item1", LocalDate.of(2025, 5, 1), 29);
        itemRepository.save(item); //first transactional method
        loggingService.logAMessage("adding item with name " + item.getName());
    }

}
