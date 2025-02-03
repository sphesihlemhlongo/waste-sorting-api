package com.enviro.assessment.grad001.sphesihlemhlongo.wastesortingapi.service;

import com.enviro.assessment.grad001.sphesihlemhlongo.wastesortingapi.exception.ResourceNotFoundException;
import com.enviro.assessment.grad001.sphesihlemhlongo.wastesortingapi.model.WasteCategory;
import com.enviro.assessment.grad001.sphesihlemhlongo.wastesortingapi.repository.WasteCategoryRepository;
import com.enviro.assessment.grad001.sphesihlemhlongo.wastesortingapi.service.WasteCategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WasteCategoryServiceImpl implements WasteCategoryService {

    private final WasteCategoryRepository wasteCategoryRepository;

    public WasteCategoryServiceImpl(WasteCategoryRepository wasteCategoryRepository) {
        this.wasteCategoryRepository = wasteCategoryRepository;
    }

    @Override
    public WasteCategory createWasteCategory(WasteCategory wasteCategory) {
        return wasteCategoryRepository.save(wasteCategory);
    }

    @Override
    public List<WasteCategory> getAllWasteCategories() {
        return wasteCategoryRepository.findAll();
    }

    @Override
    public Optional<WasteCategory> getWasteCategoryById(Long id) {
        return wasteCategoryRepository.findById(id);
    }

    @Override
    public WasteCategory updateWasteCategory(Long id, WasteCategory updatedCategory) {
        return wasteCategoryRepository.findById(id).map(category -> {
            category.setName(updatedCategory.getName());
            category.setDisposalGuidelines(updatedCategory.getDisposalGuidelines());
            return wasteCategoryRepository.save(category);
        }).orElseThrow(() -> new ResourceNotFoundException("Waste Category not found with id: " + id));
    }

    @Override
    public void deleteWasteCategory(Long id) {
        if (!wasteCategoryRepository.existsById(id)) {
            throw new ResourceNotFoundException("Waste Category not found with id: " + id);
        }
        wasteCategoryRepository.deleteById(id);
    }
}