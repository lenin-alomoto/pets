package com.app.micro_pet_management.management.infrastructure.rest.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class PetFilterRequest {

    private String breed;

    private String breedGroup;

    @Min(0)
    private Integer minAge;

    @Min(0)
    private Integer maxAge;

    @DecimalMin("0.0")
    private BigDecimal minWeight;

    @DecimalMin("0.0")
    private BigDecimal maxWeight;

    @DecimalMin("0.0")
    private BigDecimal minHeight;

    @DecimalMin("0.0")
    private BigDecimal maxHeight;
}