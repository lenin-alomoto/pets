package com.app.micro_pet_management.management.infrastructure.rest.mapper;

import org.mapstruct.Mapper;

import com.app.micro_pet_management.management.domain.model.Pet;
import com.app.micro_pet_management.management.infrastructure.rest.dto.PetRequest;
import com.app.micro_pet_management.management.infrastructure.rest.dto.PetResponse;

@Mapper
public interface PetRestMapper {

	Pet toDomain(PetRequest petRequest);
	
	PetResponse toResponse(Pet pet);
}
