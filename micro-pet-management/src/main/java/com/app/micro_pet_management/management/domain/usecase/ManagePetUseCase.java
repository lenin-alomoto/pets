package com.app.micro_pet_management.management.domain.usecase;

import java.util.List;

import com.app.micro_pet_management.management.domain.model.Pet;
import com.app.micro_pet_management.management.domain.model.PetFilter;

public interface ManagePetUseCase {
	Pet savePet(Pet pet);
	List<Pet> findAllByFilters(PetFilter petFilter);
}
