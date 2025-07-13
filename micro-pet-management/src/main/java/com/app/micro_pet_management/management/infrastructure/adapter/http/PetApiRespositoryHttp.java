package com.app.micro_pet_management.management.infrastructure.adapter.http;

import java.util.Arrays;
import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.app.micro_pet_management.management.infrastructure.adapter.http.dto.DogApiResponse;
import com.app.micro_pet_management.management.infrastructure.rest.exception.ExternalApiException;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class PetApiRespositoryHttp {
	
	private final RestTemplate restTemplate;

	@Cacheable("dogBreeds")
    public List<DogApiResponse> findAll() {
        String url = "https://api.thedogapi.com/v1/breeds";
        ResponseEntity<DogApiResponse[]> response = restTemplate.getForEntity(url, DogApiResponse[].class);
        DogApiResponse[] body = response.getBody();

        if (!response.getStatusCode().is2xxSuccessful() || body == null) {
            log.error("La API de razas retornó un error o un cuerpo nulo.");
            throw new ExternalApiException("Error al consumir el proveedor externo de razas.");
        }

        log.info("Número de razas recibidas desde la API externa: {}", body.length);
        return Arrays.asList(body);
    }
}
