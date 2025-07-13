package com.app.micro_pet_management.management.infrastructure.rest;

import java.util.List;

import org.mapstruct.factory.Mappers;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.micro_pet_management.management.domain.model.Pet;
import com.app.micro_pet_management.management.domain.usecase.ManagePetUseCase;
import com.app.micro_pet_management.management.infrastructure.rest.dto.PetFilterRequest;
import com.app.micro_pet_management.management.infrastructure.rest.dto.PetRequest;
import com.app.micro_pet_management.management.infrastructure.rest.dto.PetResponse;
import com.app.micro_pet_management.management.infrastructure.rest.mapper.PetRestMapper;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/v1/app/mange-pet")
@RequiredArgsConstructor
public class PetController {
	
	private PetRestMapper petRestMapper = Mappers.getMapper(PetRestMapper.class);
	
	private final ManagePetUseCase managePetUseCase;
	
	@PostMapping
	public ResponseEntity<PetResponse> createPet(@RequestBody PetRequest petRequest) {
        Pet savedPet = managePetUseCase.savePet(petRestMapper.toDomain(petRequest));
        PetResponse response = petRestMapper.toResponse(savedPet);
        log.info("Created pet");
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/filter")
	public ResponseEntity<List<PetResponse>> filters(@Valid @ModelAttribute PetFilterRequest petFilterRequest) {
		
        List<PetResponse> filteredPets = petRestMapper.toResponse(managePetUseCase.findAllByFilters(petRestMapper.toDomainFilter(petFilterRequest)));
        log.info("Filter number pets: {}", filteredPets.size());
        return ResponseEntity.ok(filteredPets);
	}
}
