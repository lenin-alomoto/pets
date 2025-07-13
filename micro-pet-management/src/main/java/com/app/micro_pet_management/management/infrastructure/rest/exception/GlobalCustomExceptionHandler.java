package com.app.micro_pet_management.management.infrastructure.rest.exception;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.app.micro_pet_management.management.infrastructure.rest.dto.ErrorDto;

@RestControllerAdvice
public class GlobalCustomExceptionHandler {
	
	@ExceptionHandler(BreedNotFoundException.class)
    public ResponseEntity<ErrorDto> handleBreedNotFound(BreedNotFoundException ex) {
		HttpStatus status = HttpStatus.NOT_FOUND;
		ErrorDto error = new ErrorDto(
				LocalDate.now(),
				status.value(),
				"No Resource Found", 
				ex.getMessage()
		);
        return ResponseEntity.status(status).body(error);
    }
	
	@ExceptionHandler(ExternalApiException .class)
    public ResponseEntity<ErrorDto> handleExternalApiError(ExternalApiException  ex) {
		HttpStatus status = HttpStatus.BAD_GATEWAY;
		ErrorDto error = new ErrorDto(
				LocalDate.now(),
				status.value(),
				"Bad external API gateway", 
				ex.getMessage()
		);
        return ResponseEntity.status(status).body(error);
    }
}
