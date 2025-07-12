package com.app.micro_pet_management.management.application;

import org.springframework.stereotype.Service;

import com.app.micro_pet_management.management.domain.model.Pet;
import com.app.micro_pet_management.management.domain.repository.ManagePetRepositoryPort;
import com.app.micro_pet_management.management.domain.usecase.ManagePetUseCase;
import com.app.micro_pet_management.management.domain.usecase.PetApiUseCase;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ManagePetUseCaseImpl implements ManagePetUseCase {

	private final ManagePetRepositoryPort managePetRepositoryPort;

	private final PetApiUseCase petApiUseCase;

	@Override
	public Pet savePet(Pet pet) {
		Pet apiPet = petApiUseCase.findByBreed(pet.getBreedGroup());

		pet.setLifeSpan(apiPet.getLifeSpan());
		pet.setWeight(apiPet.getWeight());
		pet.setHeight(apiPet.getHeight());
		pet.setTemperament(apiPet.getTemperament());
		pet.setBreedGroup(apiPet.getBreedGroup());
		pet.setBredFor(apiPet.getBredFor());

		return managePetRepositoryPort.savePet(pet);
	}

}
