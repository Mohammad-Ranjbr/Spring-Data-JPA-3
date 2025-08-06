package com.example.SpringDataJpa3.client;

import com.example.SpringDataJpa3.entity.Guide;
import com.example.SpringDataJpa3.service.CollegeManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class User2Client implements Runnable{

    private final CollegeManagementService collegeManagementService;

    @Autowired
    public User2Client(CollegeManagementService collegeManagementService) {
        this.collegeManagementService = collegeManagementService;
    }

    @Override
    public void run() {
        Guide guide = collegeManagementService.findGuideById(2L);
        guide.setSalary(4000);
        collegeManagementService.updateGuide(guide);
    }

}
