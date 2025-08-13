package com.example.SpringDataJpa3.client;

import com.example.SpringDataJpa3.service.CollegeManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class ProjectionsClient implements ApplicationRunner {

    private final CollegeManagementService collegeManagementService;

    @Autowired
    public ProjectionsClient(CollegeManagementService collegeManagementService) {
        this.collegeManagementService = collegeManagementService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        collegeManagementService.populateDb();
        collegeManagementService.displayNameAndSalaryOfFirst3GuidesBySalaryGreaterThan2000();
        collegeManagementService.displayInfoOfFirst3GuidesBySalaryGreaterThan2000();
    }

}
