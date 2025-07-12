package com.app.micro_pet_management.management.application;

import org.springframework.stereotype.Service;

import com.app.micro_pet_management.management.domain.model.Pet;
import com.app.micro_pet_management.management.domain.repository.PetApiRepositoryPort;
import com.app.micro_pet_management.management.domain.usecase.PetApiUseCase;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class PetApiUseCaseImpl implements PetApiUseCase {

	private final PetApiRepositoryPort petApiRepositoryPort;
	
	@Override
	public Pet findByBreed(String breed) {
		return petApiRepositoryPort.findByBreed(breed);
	}

}
