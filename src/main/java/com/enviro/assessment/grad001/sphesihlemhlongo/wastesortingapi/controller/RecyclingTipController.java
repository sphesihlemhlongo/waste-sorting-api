package com.enviro.assessment.grad001.sphesihlemhlongo.wastesortingapi.controller;

import com.enviro.assessment.grad001.sphesihlemhlongo.wastesortingapi.model.RecyclingTip;
import com.enviro.assessment.grad001.sphesihlemhlongo.wastesortingapi.service.RecyclingTipService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recycling-tips")
public class RecyclingTipController {
    private final RecyclingTipService service;

    public RecyclingTipController(RecyclingTipService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<RecyclingTip>> getAllTips() {
        return ResponseEntity.ok(service.getAllTips());
    }

    @PostMapping
    public ResponseEntity<RecyclingTip> createTip(@RequestBody RecyclingTip tip) {
        return ResponseEntity.ok(service.createTip(tip));
    }
}