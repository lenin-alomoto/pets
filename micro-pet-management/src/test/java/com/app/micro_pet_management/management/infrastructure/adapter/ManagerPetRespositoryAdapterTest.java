package com.app.micro_pet_management.management.infrastructure.adapter;

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
import org.springframework.data.jpa.domain.Specification;

import com.app.micro_pet_management.management.domain.model.Pet;
import com.app.micro_pet_management.management.domain.model.PetFilter;
import com.app.micro_pet_management.management.infrastructure.adapter.entity.PetEntity;
import com.app.micro_pet_management.management.infrastructure.adapter.mapper.PetMapper;
import com.app.micro_pet_management.management.infrastructure.adapter.repository.PetRespositoryJpa;

@ExtendWith(MockitoExtension.class)
class ManagerPetRespositoryAdapterTest {

	@Mock
	private PetRespositoryJpa petRespositoryJpa;

	@InjectMocks
	private ManagerPetRespositoryAdapter managerPetRespositoryAdapter;

	@Mock
	private PetMapper petMapper;

	@Test
	void testSavePet() {
		Pet pet = new Pet();
		PetEntity petEntity = new PetEntity();

	    when(petRespositoryJpa.save(any(PetEntity.class))).thenReturn(petEntity);

		Pet petResult = managerPetRespositoryAdapter.savePet(pet);

		assertEquals(pet.getName(), petResult.getName());
	}

	@Test
	void testFindAllByFilters() {
		PetFilter petFilter = new PetFilter();
        PetEntity petEntity = new PetEntity();

        when(petRespositoryJpa.findAll(any(Specification.class))).thenReturn(List.of(petEntity));

        List<Pet> result = managerPetRespositoryAdapter.findAllByFilters(petFilter);

        assertEquals(1, result.size());
        verify(petRespositoryJpa).findAll(any(Specification.class));
	}

}
