package com.app.micro_pet_management.management.infrastructure.adapter.entity;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class MeasurementEntity {
	private String imperial;
    private String metric;
}
