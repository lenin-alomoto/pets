package com.app.micro_pet_management.management.infrastructure.rest.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PetResponse {
	private String name;
    private int age;
    private String adrres;
    private String city;
    private String breed;
    private String lifeSpan;
    private MeasurementResponse weight;
    private MeasurementResponse height;
    private String breedGroup;
    private String temperament;
    private String bredFor;
}
