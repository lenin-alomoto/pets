package com.app.micro_pet_management.management.infrastructure.adapter.specification;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.app.micro_pet_management.management.domain.model.PetFilter;
import com.app.micro_pet_management.management.infrastructure.adapter.entity.PetEntity;

@ExtendWith(SpringExtension.class)
class PetSpecificationBuilderTest {

	@Test
    void shouldBuildSpecificationWithBreedAndAgeRange() {
        PetFilter filter = new PetFilter();
        filter.setBreed("retriever");
        filter.setMinAge(1);
        filter.setMaxAge(10);

        Specification<PetEntity> spec = PetSpecificationBuilder.build(filter);

        assertNotNull(spec);
    }
}
