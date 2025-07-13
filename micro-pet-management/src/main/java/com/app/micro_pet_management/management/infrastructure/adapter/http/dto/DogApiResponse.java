package com.app.micro_pet_management.management.infrastructure.adapter.http.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DogApiResponse {

	private String name;
	@JsonProperty("life_span")
	private String lifeSpan;

	private MeasurementApiResponse weight;

	private MeasurementApiResponse height;

	@JsonProperty("breed_group")
	private String breedGroup;

	private String temperament;

	@JsonProperty("bred_for")
	private String bredFor;

}
