package com.app.micro_pet_management.management.infrastructure.adapter;

import org.springframework.stereotype.Repository;

import com.app.micro_pet_management.management.domain.model.Pet;
import com.app.micro_pet_management.management.domain.repository.PetApiRepositoryPort;
import com.app.micro_pet_management.management.infrastructure.adapter.http.PetApiRespositoryHttp;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
@RequiredArgsConstructor
public class PetApiRepositoryAdapter implements PetApiRepositoryPort {

	private final PetApiRespositoryHttp apiHttp;

	@Override
	public Pet findByBreed(String breed) {
		return apiHttp.findAll()
                .stream()
                .filter(pet -> pet.getBreedGroup().equalsIgnoreCase(breed))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Raza no encontrada"));
	}

}
