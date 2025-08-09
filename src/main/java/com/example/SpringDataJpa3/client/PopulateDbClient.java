package com.example.SpringDataJpa3.client;

import com.example.SpringDataJpa3.entity.Guide;
import com.example.SpringDataJpa3.repository.GuideRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Order(1)
@Component
public class PopulateDbClient implements ApplicationRunner {

    private final GuideRepository guideRepository;

    @Autowired
    public PopulateDbClient(GuideRepository guideRepository) {
        this.guideRepository = guideRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<Guide> guides = new ArrayList<>();
        guides.add(new Guide("2000MO", "Mike Lawson", 1000));
        guides.add(new Guide("2001MO", "Ian Lamb", 4000));
        guides.add(new Guide("2002MO", "David Crow", 3000));
        guideRepository.saveAll(guides);
    }

}
