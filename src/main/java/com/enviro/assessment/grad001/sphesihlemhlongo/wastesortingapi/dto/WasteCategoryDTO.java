package com.enviro.assessment.grad001.sphesihlemhlongo.wastesortingapi.dto;

import javax.validation.constraints.NotBlank;

public class WasteCategoryDTO {

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Disposal guidelines cannot be empty")
    private String disposalGuidelines;

    // Constructors
    public WasteCategoryDTO() {}

    public WasteCategoryDTO(String name, String disposalGuidelines) {
        this.name = name;
        this.disposalGuidelines = disposalGuidelines;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisposalGuidelines() {
        return disposalGuidelines;
    }

    public void setDisposalGuidelines(String disposalGuidelines) {
        this.disposalGuidelines = disposalGuidelines;
    }
}
