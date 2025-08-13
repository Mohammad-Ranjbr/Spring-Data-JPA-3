package com.example.SpringDataJpa3.service;

import com.example.SpringDataJpa3.entity.Guide;
import com.example.SpringDataJpa3.projection.GuideNameSalary;
import com.example.SpringDataJpa3.repository.GuideRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CollegeManagementService {

    private final GuideRepository guideRepository;

    @Autowired
    public CollegeManagementService(GuideRepository guideRepository) {
        this.guideRepository = guideRepository;
    }

    @Transactional
    public void persistingSomeGuides() {
        Guide guide1 = new Guide("2000MO10789", "Mike Lawson", 1000);
        Guide guide2 = new Guide("2001MO10123", "Ian Lamb", 2000);
        guideRepository.saveAll(List.of(guide1, guide2));
    }

    @Transactional
    public void fetchingReadWriteGuide() {
        Guide guide = guideRepository.findById(1L).get();
        guide.setSalary(2500);
    }

    @Transactional(readOnly = true)
    public void fetchingReadOnlyGuide() {
        Guide guide = guideRepository.findById(1L).get();
        guide.setSalary(2500);
    }

    @Transactional(readOnly = true)
    public Guide findGuideById(Long id) {
        return guideRepository.findById(id).get();
    }

    @Transactional
    public void updateGuide(Guide guide) {
        guideRepository.save(guide);
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public void prepareNameAndSalaryReportOfAllGuides() {
        List<Object[]> resultList = guideRepository.getNameAndSalaryOfAll();
        for (Object[] result : resultList) {
            System.out.println("Name: " + result[0] + " Salary: " + result[1]);
        }
        System.out.println("The total salary of all the guides is " + guideRepository.calculateSumOfAllSalaries());
    }

    @Transactional
    public void raiseSalaryOfGuide(Long id, Integer newSalary) {
        Guide guide = guideRepository.findById(id).get();
        guide.setSalary(newSalary);
    }

    public void populateDb() {
        List<Guide> guides = new ArrayList<>();
        guides.add(new Guide("2000MO10789", "Mike Lawson", 1000));
        guides.add(new Guide("2008IM10901", "Ian Lamb", 4000));
        guides.add(new Guide("2012DO10777", "David Crow", 3000));
        guides.add(new Guide("2020HN10865", "Henry Smith", 2000));
        guides.add(new Guide("2021DO10499", "Diane Lynn", 3500));
        guides.add(new Guide("2017ES50489", "Eric Walsh", 2500));
        guideRepository.saveAll(guides);
    }

    @Transactional(readOnly = true)
    public void displayNameAndSalaryOfFirst3GuidesBySalaryGreaterThan2000() {
        List<GuideNameSalary> proxies = guideRepository.findFirst3BySalaryGreaterThan(2000);
        for(GuideNameSalary proxy : proxies) {
            System.out.println("Name: " + proxy.getName() + "\t\t Salary: " + proxy.getSalary());
        }
    }

     @Transactional(readOnly = true)
    public void displayInfoOfFirst3GuidesBySalaryGreaterThan2000() {
        List<GuideNameSalary> proxies = guideRepository.findFirst3BySalaryGreaterThan(2000);
        for(GuideNameSalary proxy : proxies) {
            System.out.println(proxy.getInfo());
        }
     }

}
