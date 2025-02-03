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
        List<RecyclingTip> tips = recyclingTipRepository.findAll();
        if (tips.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(tips);
        }
        return ResponseEntity.ok(tips);
    }

    // Update a Recycling Tip
    @PutMapping("/{id}")
    public ResponseEntity<RecyclingTip> updateRecyclingTip(@PathVariable Long id, @Valid @RequestBody RecyclingTip updatedTip) {
        return recyclingTipRepository.findById(id)
                .map(existingTip -> {
                    existingTip.setTip(updatedTip.getTip());
                    RecyclingTip savedTip = recyclingTipRepository.save(existingTip);
                    return ResponseEntity.ok(savedTip);
                })
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Delete a Recycling Tip
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRecyclingTip(@PathVariable Long id) {
        return recyclingTipRepository.findById(id)
                .map(tip -> {
                    recyclingTipRepository.delete(tip);
                    return ResponseEntity.ok("Recycling Tip deleted successfully");
                })
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("Recycling Tip not found"));
    }


}