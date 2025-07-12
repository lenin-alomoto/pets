package com.app.micro_pet_management.management.infrastructure.rest.exception;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.app.micro_pet_management.management.infrastructure.rest.dto.ErrorDto;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(BreedNotFoundException.class)
    public ResponseEntity<ErrorDto> handleBreedNotFound(BreedNotFoundException ex) {
		ErrorDto error = new ErrorDto(
				LocalDate.now(),
				HttpStatus.NOT_FOUND.value(),
				"No Resource Found", 
				ex.getMessage()
		);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}
