package com.app.micro_pet_management.management.infrastructure.adapter;

import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Repository;

import com.app.micro_pet_management.management.domain.model.Pet;
import com.app.micro_pet_management.management.domain.repository.PetApiRepositoryPort;
import com.app.micro_pet_management.management.infrastructure.adapter.http.PetApiRespositoryHttp;
import com.app.micro_pet_management.management.infrastructure.adapter.http.mapper.PetApiMapper;
import com.app.micro_pet_management.management.infrastructure.rest.exception.BreedNotFoundException;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
@RequiredArgsConstructor
public class PetApiRepositoryAdapter implements PetApiRepositoryPort {
	
	private PetApiMapper petApiMapper = Mappers.getMapper(PetApiMapper.class);

	private final PetApiRespositoryHttp apiHttp;

	@Override
	public Pet findByBreed(String breed) {
		log.info("Breed to look for: {}", breed);
		return apiHttp.findAll()
                .stream()
                .filter(dog -> dog.getName() != null && dog.getName().toLowerCase().contains(breed.toLowerCase()))
                .findFirst()
                .map(petApiMapper::toDomain)
                .orElseThrow(() -> new BreedNotFoundException(breed));
	}

}
