package com.app.micro_pet_management.management.domain.repository;

import java.util.List;

import com.app.micro_pet_management.management.domain.model.Pet;
import com.app.micro_pet_management.management.domain.model.PetFilter;

public interface ManagePetRepositoryPort {
	Pet savePet(Pet pet);
	List<Pet> findAllByFilters(PetFilter petFilter);
}
