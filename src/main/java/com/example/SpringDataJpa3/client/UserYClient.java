package com.example.SpringDataJpa3.client;

import com.example.SpringDataJpa3.service.CollegeManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserYClient implements Runnable{

    private final CollegeManagementService collegeManagementService;

    @Autowired
    public UserYClient(CollegeManagementService collegeManagementService) {
        this.collegeManagementService = collegeManagementService;
    }

    @Override
    public void run() {
        collegeManagementService.raiseSalaryOfGuide(3L, 4000);
    }

}
