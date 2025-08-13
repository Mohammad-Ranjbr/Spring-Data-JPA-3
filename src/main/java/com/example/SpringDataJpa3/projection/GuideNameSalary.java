package com.example.SpringDataJpa3.projection;

import org.springframework.beans.factory.annotation.Value;

public interface GuideNameSalary {

    String getName();
    Integer getSalary();

    @Value("#{target.name} \t #{target.salary}") //target represents the entire original entity
    String getInfo();

}
