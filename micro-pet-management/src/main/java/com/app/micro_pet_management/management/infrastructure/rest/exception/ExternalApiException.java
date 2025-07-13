package com.app.micro_pet_management.management.infrastructure.rest.exception;

public class ExternalApiException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ExternalApiException(String message) {
        super(message);
    }

}
