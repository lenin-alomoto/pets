package com.app.micro_pet_management.management.infrastructure.adapter.http.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.app.micro_pet_management.management.domain.model.Pet;
import com.app.micro_pet_management.management.infrastructure.adapter.http.dto.DogApiResponse;

@Mapper
public interface PetApiMapper {

	@Mapping(ignore=true, target="age")
	@Mapping(ignore=true, target="adrres")
	@Mapping(ignore=true, target="city")
	@Mapping(ignore=true, target="breed")
	@Mapping(ignore=true, target="maxHeight")
	@Mapping(ignore=true, target="maxWeight")
	@Mapping(ignore=true, target="minHeight")
	@Mapping(ignore=true, target="minWeight")
	Pet toDomain(DogApiResponse dogApiResponse);
}
