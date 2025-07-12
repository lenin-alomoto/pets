package com.app.micro_pet_management.management.infrastructure.rest.exception;

public class BreedNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public BreedNotFoundException(String breed) {
        super("No se encontraron datos para la raza: " + breed);
    }
}
