package com.app.micro_pet_management.management.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Measurement {
	private String imperial;
    private String metric;
}
