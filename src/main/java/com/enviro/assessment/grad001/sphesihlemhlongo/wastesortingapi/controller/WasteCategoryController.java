package com.enviro.assessment.grad001.sphesihlemhlongo.wastesortingapi.controller;

import com.enviro.assessment.grad001.sphesihlemhlongo.wastesortingapi.model.WasteCategory;
import com.enviro.assessment.grad001.sphesihlemhlongo.wastesortingapi.service.WasteCategoryService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/waste-categories")
public class WasteCategoryController {

    private final WasteCategoryService wasteCategoryService;

    public WasteCategoryController(WasteCategoryService wasteCategoryService) {
        this.wasteCategoryService = wasteCategoryService;
    }

    // Create a new waste category
    @PostMapping
    public ResponseEntity<WasteCategory> createWasteCategory(@Valid @RequestBody WasteCategory wasteCategory) {
        return ResponseEntity.ok(wasteCategoryService.createWasteCategory(wasteCategory));
    }

    // Get all waste categories
    @GetMapping
    public ResponseEntity<List<WasteCategory>> getAllWasteCategories() {
        return ResponseEntity.ok(wasteCategoryService.getAllWasteCategories());
    }

    // Get a single waste category by ID
    @GetMapping("/{id}")
    public ResponseEntity<WasteCategory> getWasteCategoryById(@PathVariable Long id) {
        Optional<WasteCategory> category = wasteCategoryService.getWasteCategoryById(id);
        return category.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update a waste category
    @PutMapping("/{id}")
    public ResponseEntity<WasteCategory> updateWasteCategory(@PathVariable Long id, @Valid @RequestBody WasteCategory updatedCategory) {
        return ResponseEntity.ok(wasteCategoryService.updateWasteCategory(id, updatedCategory));
    }

    // Delete a waste category
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWasteCategory(@PathVariable Long id) {
        wasteCategoryService.deleteWasteCategory(id);
        return ResponseEntity.noContent().build();
    }
}