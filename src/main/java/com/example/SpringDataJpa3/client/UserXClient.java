package com.example.SpringDataJpa3.client;

import com.example.SpringDataJpa3.service.CollegeManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserXClient implements Runnable{

    private final CollegeManagementService collegeManagementService;

    @Autowired
    public UserXClient(CollegeManagementService collegeManagementService) {
        this.collegeManagementService = collegeManagementService;
    }

    @Override
    public void run() {
        collegeManagementService.prepareNameAndSalaryReportOfAllGuides();
    }

}
