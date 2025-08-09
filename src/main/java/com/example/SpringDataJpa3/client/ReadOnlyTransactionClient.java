package com.example.SpringDataJpa3.client;

import com.example.SpringDataJpa3.service.CollegeManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

//@Component
public class ReadOnlyTransactionClient implements ApplicationRunner {

    private final CollegeManagementService collegeManagementService;

    @Autowired
    ReadOnlyTransactionClient(CollegeManagementService collegeManagementService) {
        this.collegeManagementService = collegeManagementService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        collegeManagementService.persistingSomeGuides();
        //collegeManagementService.fetchingReadWriteGuide();
        collegeManagementService.fetchingReadOnlyGuide();
    }

}
