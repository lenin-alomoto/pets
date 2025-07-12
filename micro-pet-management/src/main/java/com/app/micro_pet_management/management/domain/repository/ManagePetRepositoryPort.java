package com.app.micro_pet_management.management.domain.repository;

import com.app.micro_pet_management.management.domain.model.Pet;

public interface ManagePetRepositoryPort {
	Pet savePet(Pet pet);
}
