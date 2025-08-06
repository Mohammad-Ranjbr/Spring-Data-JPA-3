package com.example.SpringDataJpa3.client;

import com.example.SpringDataJpa3.entity.Guide;
import com.example.SpringDataJpa3.service.CollegeManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.stereotype.Component;

@Component
public class User1Client implements Runnable{

    //Every class that implements Runnable must implement this run() method. This method contains the code that is going to be executed in a separate thread.

    private final CollegeManagementService collegeManagementService;

    @Autowired
    public User1Client(CollegeManagementService collegeManagementService) {
        this.collegeManagementService = collegeManagementService;
    }

    @Override
    public void run() {
        Guide guide = collegeManagementService.findGuideById(2L);
        guide.setSalary(3000);
        //collegeManagementService.updateGuide(guide);
        try {
            collegeManagementService.updateGuide(guide);
        } catch (ObjectOptimisticLockingFailureException e) {
            System.out.println("\033[0;31m" + "The Guide#2 was updated by some other user, while you were occupied with something else.");
        }
    }

}
