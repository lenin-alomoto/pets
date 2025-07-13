package com.app.micro_pet_management.management.infrastructure.rest.dto;

import java.time.LocalDate;

public  record ErrorDto(
		LocalDate date,
		int status,
		String error,
		String message 
	) {

}

