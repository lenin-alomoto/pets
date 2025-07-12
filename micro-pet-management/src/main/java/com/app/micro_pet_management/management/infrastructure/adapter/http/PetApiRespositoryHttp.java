package com.app.micro_pet_management.management.infrastructure.adapter.http;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.app.micro_pet_management.management.domain.model.Pet;

@Component
public class PetApiRespositoryHttp {
	
	private final RestTemplate restTemplate;

    public PetApiRespositoryHttp() {
        this.restTemplate = new RestTemplate();
    }

    public List<Pet> findAll() {
        String url = "https://api.thedogapi.com/v1/breeds";
        ResponseEntity<Pet[]> response = restTemplate.getForEntity(url, Pet[].class);
        return Arrays.asList(Objects.requireNonNull(response.getBody()));
    }
}
