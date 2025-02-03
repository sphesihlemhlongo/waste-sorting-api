package com.enviro.assessment.grad001.sphesihlemhlongo.wastesortingapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name = "waste_categories")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WasteCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Category name is required")
    @Column(nullable = false, unique = true)
    private String name;

    @NotBlank(message = "Disposal guidelines are required")
    @Column(nullable = false)
    private String disposalGuidelines;

}



