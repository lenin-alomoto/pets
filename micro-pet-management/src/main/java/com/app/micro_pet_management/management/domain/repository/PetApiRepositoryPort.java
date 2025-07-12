package com.app.micro_pet_management.management.domain.repository;

import com.app.micro_pet_management.management.domain.model.Pet;

public interface PetApiRepositoryPort {
	Pet findByBreed(String breed);
}
