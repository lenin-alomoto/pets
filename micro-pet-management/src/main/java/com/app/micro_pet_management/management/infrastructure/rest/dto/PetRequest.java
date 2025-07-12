package com.app.micro_pet_management.management.infrastructure.rest.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PetRequest {
	private String name;
    private int age;
    private String adrres;
    private String city;
    private String breed;
}
