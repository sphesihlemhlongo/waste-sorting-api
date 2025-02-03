package com.enviro.assessment.grad001.sphesihlemhlongo.wastesortingapi.service;

import com.enviro.assessment.grad001.sphesihlemhlongo.wastesortingapi.model.DisposalGuideline;
import com.enviro.assessment.grad001.sphesihlemhlongo.wastesortingapi.repository.DisposalGuidelineRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisposalGuidelineService {
    private final DisposalGuidelineRepository repository;

    public DisposalGuidelineService(DisposalGuidelineRepository repository) {
        this.repository = repository;
    }

    public List<DisposalGuideline> getAllGuidelines() {
        return repository.findAll();
    }

    public DisposalGuideline createGuideline(DisposalGuideline guideline) {
        return repository.save(guideline);
    }
}