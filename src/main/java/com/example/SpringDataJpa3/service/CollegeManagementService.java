package com.example.SpringDataJpa3.service;

import com.example.SpringDataJpa3.entity.Guide;
import com.example.SpringDataJpa3.repository.GuideRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

}
