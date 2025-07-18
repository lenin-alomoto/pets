package com.app.micro_pet_management.management.infrastructure.rest.exception;

import java.time.LocalDate;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import com.app.micro_pet_management.management.infrastructure.rest.dto.ErrorDto;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler({ NoResourceFoundException.class })
	public ResponseEntity<ErrorDto> noResourceFound(Exception ex) {
		ErrorDto errorDto = new ErrorDto(
				LocalDate.now(), 
				HttpStatus.NOT_FOUND.value(),
				"No Resource Found", 
				ex.getMessage());
		return new ResponseEntity<>(errorDto, new HttpHeaders(), HttpStatus.NOT_FOUND);
	}
}
