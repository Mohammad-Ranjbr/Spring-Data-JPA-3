package com.example.SpringDataJpa3.client;

import com.example.SpringDataJpa3.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TransactionPropagationClient implements CommandLineRunner {

    private final ItemService itemService;

    @Autowired
    public TransactionPropagationClient(ItemService itemService) {
        this.itemService = itemService;
    }

    @Override
    public void run(String... args) throws Exception {
        itemService.persistAnItem();
     }

}
