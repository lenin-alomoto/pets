package com.app.micro_pet_management.management.domain.usecase;

import com.app.micro_pet_management.management.domain.model.Pet;

public interface PetApiUseCase {
	Pet findByBreed(String breed);
}
