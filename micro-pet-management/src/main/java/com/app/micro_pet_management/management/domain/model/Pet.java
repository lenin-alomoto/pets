package com.app.micro_pet_management.management.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pet {
	private String name;
	private int age;
	private String adrres;
	private String city;
	private String breedGroup;
	private String lifeSpan;
	private Measurement weight; 
    private Measurement height;
	private String temperament;
	private String bredFor;
}
