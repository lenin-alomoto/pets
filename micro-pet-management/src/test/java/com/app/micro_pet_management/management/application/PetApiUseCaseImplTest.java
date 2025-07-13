package com.app.micro_pet_management.management.application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.app.micro_pet_management.management.domain.model.Pet;
import com.app.micro_pet_management.management.domain.repository.PetApiRepositoryPort;

@ExtendWith(MockitoExtension.class)
class PetApiUseCaseImplTest {
	
	@Mock
    private PetApiRepositoryPort petApiRepositoryPort;

    @InjectMocks
    private PetApiUseCaseImpl petApiUseCaseImpl;

	@Test
	void testFindByBreed() {
		Pet expectedPet = new Pet();
        when(petApiRepositoryPort.findByBreed("poodle")).thenReturn(expectedPet);

        Pet petResult = petApiUseCaseImpl.findByBreed("poodle");
        assertEquals(expectedPet, petResult);
	}

}
