package com.app.micro_pet_management.management.infrastructure.rest.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.app.micro_pet_management.management.domain.model.Pet;
import com.app.micro_pet_management.management.domain.model.PetFilter;
import com.app.micro_pet_management.management.infrastructure.rest.dto.PetFilterRequest;
import com.app.micro_pet_management.management.infrastructure.rest.dto.PetRequest;
import com.app.micro_pet_management.management.infrastructure.rest.dto.PetResponse;

@Mapper
public interface PetRestMapper {

	@Mapping(ignore=true, target="breedGroup")
	@Mapping(ignore=true, target="lifeSpan")
	@Mapping(ignore=true, target="weight")
	@Mapping(ignore=true, target="height")
	@Mapping(ignore=true, target="temperament")
	@Mapping(ignore=true, target="bredFor")
	@Mapping(ignore=true, target="minWeight")
	@Mapping(ignore=true, target="maxWeight")
	@Mapping(ignore=true, target="minHeight")
	@Mapping(ignore=true, target="maxHeight")
	Pet toDomain(PetRequest petRequest);
	
	PetFilter toDomainFilter(PetFilterRequest petFilterRequest);
	
	PetResponse toResponse(Pet pet);
	List<PetResponse> toResponse(List<Pet> pet);
}
