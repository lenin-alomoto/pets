package com.app.micro_pet_management.management.infrastructure.rest;

import org.mapstruct.factory.Mappers;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.micro_pet_management.management.domain.model.Pet;
import com.app.micro_pet_management.management.domain.usecase.ManagePetUseCase;
import com.app.micro_pet_management.management.infrastructure.rest.dto.PetRequest;
import com.app.micro_pet_management.management.infrastructure.rest.dto.PetResponse;
import com.app.micro_pet_management.management.infrastructure.rest.mapper.PetRestMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/v1/api/mange-pet")
@RequiredArgsConstructor
public class PetController {
	
	private PetRestMapper petRestMapper = Mappers.getMapper(PetRestMapper.class);
	
	private final ManagePetUseCase managePetUseCase;
	
	public ResponseEntity<PetResponse> savePet(@RequestBody PetRequest petRequest) {
		Pet pet = petRestMapper.toDomain(petRequest);
        Pet savedPet = managePetUseCase.savePet(pet);
        PetResponse response = petRestMapper.toResponse(savedPet);
		return ResponseEntity.ok(response);
	}
}
