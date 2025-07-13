package com.app.micro_pet_management.management.infrastructure.rest.exception;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;

import com.app.micro_pet_management.management.infrastructure.adapter.config.TestSecurityConfig;

@WebMvcTest(DummyController.class) 
@Import({GlobalCustomExceptionHandler.class, TestSecurityConfig.class})
class GlobalCustomExceptionHandlerTest {

	@Autowired
    private MockMvc mockMvc;

    @Test
    void whenBreedNotFound_thenReturns404() throws Exception {
        mockMvc.perform(get("/dummy/breed-not-found"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.status").value(404))
                .andExpect(jsonPath("$.message").value("No se encontraron datos para la raza: Breed not found"))
                .andExpect(jsonPath("$.error").value("No Resource Found"));
    }

    @Test
    void whenExternalApiFails_thenReturns502() throws Exception {
        mockMvc.perform(get("/dummy/external-api-error"))
                .andExpect(status().isBadGateway())
                .andExpect(jsonPath("$.status").value(502))
                .andExpect(jsonPath("$.message").value("API timeout"))
                .andExpect(jsonPath("$.error").value("Bad external API gateway"));
    }

}
