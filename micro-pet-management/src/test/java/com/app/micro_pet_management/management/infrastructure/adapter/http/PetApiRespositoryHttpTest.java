package com.app.micro_pet_management.management.infrastructure.adapter.http;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.app.micro_pet_management.management.infrastructure.adapter.http.dto.DogApiResponse;

@ExtendWith(MockitoExtension.class)
class PetApiRespositoryHttpTest {

	@Mock
	private RestTemplate restTemplate;

	@InjectMocks
	private PetApiRespositoryHttp apiHttp;

	@Test
	void testFindAll_returnsList_whenApiIsOk() {
		DogApiResponse[] dogArray = new DogApiResponse[] { new DogApiResponse() };
		ResponseEntity<DogApiResponse[]> response = new ResponseEntity<>(dogArray, HttpStatus.OK);

		when(restTemplate.getForEntity(anyString(), eq(DogApiResponse[].class))).thenReturn(response);

		List<DogApiResponse> result = apiHttp.findAll();

		assertNotNull(result);
		assertEquals(1, result.size());
	}

}
