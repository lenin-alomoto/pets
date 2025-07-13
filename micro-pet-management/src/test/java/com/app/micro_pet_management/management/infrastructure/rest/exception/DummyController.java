package com.app.micro_pet_management.management.infrastructure.rest.exception;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dummy")
class DummyController {
	@GetMapping("/breed-not-found")
    public void throwBreedNotFound() {
        throw new BreedNotFoundException("Breed not found");
    }

    @GetMapping("/external-api-error")
    public void throwExternalApiError() {
        throw new ExternalApiException("API timeout");
    }
}
