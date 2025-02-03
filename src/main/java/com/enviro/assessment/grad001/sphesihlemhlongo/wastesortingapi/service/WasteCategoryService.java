package com.enviro.assessment.grad001.sphesihlemhlongo.wastesortingapi.service;

import com.enviro.assessment.grad001.sphesihlemhlongo.wastesortingapi.model.WasteCategory;

import java.util.List;
import java.util.Optional;

public interface WasteCategoryService {
    WasteCategory createWasteCategory(WasteCategory wasteCategory);
    List<WasteCategory> getAllWasteCategories();
    Optional<WasteCategory> getWasteCategoryById(Long id);
    WasteCategory updateWasteCategory(Long id, WasteCategory updatedCategory);
    void deleteWasteCategory(Long id);
}