package com.enviro.assessment.grad001.sphesihlemhlongo.wastesortingapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DisposalGuideline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Waste type is required")
    private String wasteType;

    @NotBlank(message = "Guideline description is required")
    private String guideline;
}