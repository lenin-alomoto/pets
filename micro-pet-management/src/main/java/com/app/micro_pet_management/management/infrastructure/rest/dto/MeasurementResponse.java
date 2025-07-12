package com.app.micro_pet_management.management.infrastructure.rest.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MeasurementResponse {
	private String imperial;
    private String metric;
}
