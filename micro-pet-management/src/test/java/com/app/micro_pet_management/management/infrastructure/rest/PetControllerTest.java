package com.app.micro_pet_management.management.infrastructure.rest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.app.micro_pet_management.management.domain.model.Pet;
import com.app.micro_pet_management.management.domain.usecase.ManagePetUseCase;
import com.app.micro_pet_management.management.infrastructure.rest.dto.PetResponse;
import com.app.micro_pet_management.management.infrastructure.rest.mapper.PetRestMapper;

@WebMvcTest(PetController.class)
class PetControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockitoBean
	private ManagePetUseCase managePetUseCase;

	@MockitoBean
	private PetRestMapper petRestMapper;

	@Test
	void testCreatePet() throws Exception {
        Pet domain = new Pet();
        PetResponse response = new PetResponse();

        when(petRestMapper.toDomain(any())).thenReturn(domain);
        when(managePetUseCase.savePet(domain)).thenReturn(domain);
        when(petRestMapper.toResponse(domain)).thenReturn(response);

        mockMvc.perform(post("/v1/app/mange-pet")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                    {
                        "name": "Toby",
                        "age": 3,
                        "adrres": "Av. Siempre Viva",
                        "city": "Quito",
                        "breed": "Retriever"
                    }
                """))
            .andExpect(status().isOk());
	}

	@Test
	void testFilters() throws Exception {
		when(managePetUseCase.findAllByFilters(any())).thenReturn(List.of(new Pet()));
        when(petRestMapper.toResponse(anyList())).thenReturn(List.of(new PetResponse()));

        mockMvc.perform(get("/v1/app/mange-pet/filter"))
            .andExpect(status().isOk());
	}

}
