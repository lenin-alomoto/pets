package com.app.micro_pet_management.management.infrastructure.adapter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.app.micro_pet_management.management.domain.model.Pet;
import com.app.micro_pet_management.management.infrastructure.adapter.http.PetApiRespositoryHttp;
import com.app.micro_pet_management.management.infrastructure.adapter.http.dto.DogApiResponse;
import com.app.micro_pet_management.management.infrastructure.adapter.http.mapper.PetApiMapper;
import com.app.micro_pet_management.management.infrastructure.rest.exception.BreedNotFoundException;

@ExtendWith(MockitoExtension.class)
class PetApiRepositoryAdapterTest {

	@Mock
    private PetApiMapper petApiMapper;
	
	@Mock
    private PetApiRespositoryHttp apiHttp;

    @InjectMocks
    private PetApiRepositoryAdapter petApiRepositoryAdapter;
    
    @Test
    void testFindByBreed_success() {
        DogApiResponse dog = new DogApiResponse();
        dog.setName("Labrador");

        Pet expectedPet = new Pet();
        expectedPet.setName("Labrador");
        when(apiHttp.findAll()).thenReturn(List.of(dog));

        Pet petResult = petApiRepositoryAdapter.findByBreed("labrador");
        assertEquals(expectedPet.getName(), petResult.getName());
    }

    @Test
    void testFindByBreed_notFound_shouldThrow() {
        when(apiHttp.findAll()).thenReturn(List.of());

        assertThrows(BreedNotFoundException.class, () -> petApiRepositoryAdapter.findByBreed("x"));
    }

}
