package com.app.micro_pet_management.management.domain.model;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pet {
	private String name;
	private int age;
	private String adrres;
	private String city;
	private String breed;
	private String lifeSpan;
	private Measurement weight; 
	private BigDecimal minWeight;
	private BigDecimal maxWeight;
    private Measurement height;
    private BigDecimal minHeight;
	private BigDecimal maxHeight;
    private String breedGroup;
	private String temperament;
	private String bredFor;
}
