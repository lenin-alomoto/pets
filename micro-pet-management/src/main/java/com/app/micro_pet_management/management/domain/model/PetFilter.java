package com.app.micro_pet_management.management.domain.model;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class PetFilter {
	private String breed;
    private String breedGroup;
    private Integer minAge;
    private Integer maxAge;
    private BigDecimal minWeight;
    private BigDecimal maxWeight;
    private BigDecimal minHeight;
    private BigDecimal maxHeight;
}
