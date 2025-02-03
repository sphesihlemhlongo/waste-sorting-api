package com.enviro.assessment.grad001.sphesihlemhlongo.wastesortingapi.controller;

import com.enviro.assessment.grad001.sphesihlemhlongo.wastesortingapi.model.RecyclingTip;
import com.enviro.assessment.grad001.sphesihlemhlongo.wastesortingapi.repository.RecyclingTipRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recycling-tips")
public class RecyclingTipController {

    private final RecyclingTipRepository recyclingTipRepository;

    public RecyclingTipController(RecyclingTipRepository recyclingTipRepository) {
        this.recyclingTipRepository = recyclingTipRepository;
    }

    @PostMapping
    public ResponseEntity<?> createRecyclingTip(@Valid @RequestBody RecyclingTip recyclingTip) {
        RecyclingTip savedTip = recyclingTipRepository.save(recyclingTip);
        return new ResponseEntity<>(savedTip, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<RecyclingTip>> getAllRecyclingTips() {
        return ResponseEntity.ok(recyclingTipRepository.findAll());
    }
}