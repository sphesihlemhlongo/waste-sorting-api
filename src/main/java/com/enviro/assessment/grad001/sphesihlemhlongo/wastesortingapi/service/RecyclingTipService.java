package com.enviro.assessment.grad001.sphesihlemhlongo.wastesortingapi.service;

import com.enviro.assessment.grad001.sphesihlemhlongo.wastesortingapi.model.RecyclingTip;
import com.enviro.assessment.grad001.sphesihlemhlongo.wastesortingapi.repository.RecyclingTipRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecyclingTipService {
    private final RecyclingTipRepository repository;

    public RecyclingTipService(RecyclingTipRepository repository) {
        this.repository = repository;
    }

    public List<RecyclingTip> getAllTips() {
        return repository.findAll();
    }

    public RecyclingTip createTip(RecyclingTip tip) {
        return repository.save(tip);
    }
}