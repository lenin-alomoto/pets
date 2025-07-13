package com.app.micro_pet_management.management.application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.app.micro_pet_management.management.domain.model.Measurement;
import com.app.micro_pet_management.management.domain.model.Pet;
import com.app.micro_pet_management.management.domain.model.PetFilter;
import com.app.micro_pet_management.management.domain.repository.ManagePetRepositoryPort;
import com.app.micro_pet_management.management.domain.usecase.PetApiUseCase;

@ExtendWith(MockitoExtension.class)
class ManagePetUseCaseImplTest {
	
	@InjectMocks
	private ManagePetUseCaseImpl managePetUseCaseImpl;
	
	@Mock
	private ManagePetRepositoryPort managePetRepositoryPort; 
	
	@Mock
	private PetApiUseCase petApiUseCase;

	@Test
	void testSavePet() {
		Pet pet = new Pet();
		pet.setName("Pecosa");
		pet.setBreed("Bulldog");
		
		Pet petApi = new Pet();
        petApi.setLifeSpan("10 - 12");
        petApi.setWeight(new Measurement("20", "30"));
        petApi.setHeight(new Measurement("10", "15"));
        petApi.setTemperament("Friendly");
        petApi.setBreedGroup("Sporting");
        petApi.setBredFor("Hunting");
        
        when(petApiUseCase.findByBreed("Bulldog")).thenReturn(petApi);
		
		when(managePetRepositoryPort.savePet(any())).thenReturn(pet);
		
		Pet petResult = managePetUseCaseImpl.savePet(pet);
		
		assertEquals("Pecosa", petResult.getName());
		verify(managePetRepositoryPort).savePet(any());
	}

	@Test
	void testFindAllByFilters() {
		PetFilter petFilter = new PetFilter();
        List<Pet> petFilters = List.of(new Pet());

        when(managePetRepositoryPort.findAllByFilters(petFilter)).thenReturn(petFilters);

        List<Pet> petResult = managePetUseCaseImpl.findAllByFilters(petFilter);

        assertEquals(1, petResult.size());
	}

}
