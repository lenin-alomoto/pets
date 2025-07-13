package com.app.micro_pet_management.management.infrastructure.adapter.http.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MeasurementApiResponse {
	private String imperial;
    private String metric;
}
