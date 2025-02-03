package com.enviro.assessment.grad001.sphesihlemhlongo.wastesortingapi.controller;

import com.enviro.assessment.grad001.sphesihlemhlongo.wastesortingapi.model.WasteCategory;
import com.enviro.assessment.grad001.sphesihlemhlongo.wastesortingapi.repository.WasteCategoryRepository;
import com.enviro.assessment.grad001.sphesihlemhlongo.wastesortingapi.service.WasteCategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/waste-categories")
public class WasteCategoryController {

    private final WasteCategoryService wasteCategoryService;
    @Autowired
    private WasteCategoryRepository wasteCategoryRepository;
    private static final Logger logger = LoggerFactory.getLogger(WasteCategoryController.class);


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
    public ResponseEntity<?> updateWasteCategory(@PathVariable Long id, @Valid @RequestBody WasteCategory updatedCategory) {
        try {
            return wasteCategoryRepository.findById(id)
                    .map(existingCategory -> {
                        existingCategory.setName(updatedCategory.getName());
                        existingCategory.setDisposalGuidelines(updatedCategory.getDisposalGuidelines());
                        WasteCategory savedCategory = wasteCategoryRepository.save(existingCategory);
                        return ResponseEntity.ok(savedCategory);
                    })
                    .orElseGet(() -> {
                        logger.error("Waste Category with ID {} not found", id);
                        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
                    });
        } catch (Exception e) {
            logger.error("Error updating Waste Category with ID {}: {}", id, e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating Waste Category");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteWasteCategory(@PathVariable Long id) {
        try {
            return wasteCategoryRepository.findById(id)
                    .map(category -> {
                        wasteCategoryRepository.delete(category);
                        return ResponseEntity.ok("Waste Category deleted successfully");
                    })
                    .orElseGet(() -> {
                        logger.error("Waste Category with ID {} not found", id);
                        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Waste Category not found");
                    });
        } catch (Exception e) {
            logger.error("Error deleting Waste Category with ID {}: {}", id, e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting Waste Category");
        }
    }

    // Retrieve Disposal Guidelines by Waste Category
    @GetMapping("/{id}/guidelines")
    public ResponseEntity<String> getDisposalGuidelinesByCategory(@PathVariable Long id) {
        return wasteCategoryRepository.findById(id)
                .map(category -> ResponseEntity.ok(category.getDisposalGuidelines()))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("Waste Category not found"));
    }

}