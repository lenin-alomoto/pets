package com.app.micro_pet_management.management.application;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.micro_pet_management.management.application.util.RangeParser;
import com.app.micro_pet_management.management.domain.model.Pet;
import com.app.micro_pet_management.management.domain.model.PetFilter;
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
		log.info("Pet: {}, breed: {}", pet.getName(), pet.getBreed());
		Pet apiPet = petApiUseCase.findByBreed(pet.getBreed());
		pet.setBreed(apiPet.getName());
		pet.setLifeSpan(apiPet.getLifeSpan());
		pet.setWeight(apiPet.getWeight());
		pet.setMinWeight(RangeParser.parseMin(apiPet.getWeight().getMetric()));
        pet.setMaxWeight(RangeParser.parseMax(apiPet.getWeight().getMetric()));
        
        pet.setHeight(apiPet.getHeight());
        pet.setMinHeight(RangeParser.parseMin(apiPet.getHeight().getMetric()));
        pet.setMaxHeight(RangeParser.parseMax(apiPet.getHeight().getMetric()));
        
		pet.setTemperament(apiPet.getTemperament());
		pet.setBreedGroup(apiPet.getBreedGroup());
		pet.setBredFor(apiPet.getBredFor());

		return managePetRepositoryPort.savePet(pet);
	}

	@Override
	public List<Pet> findAllByFilters(PetFilter petFilter) {
		log.info("Filters: {}", petFilter.toString());
		return managePetRepositoryPort.findAllByFilters(petFilter);
	}

}
