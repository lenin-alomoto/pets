package com.app.micro_pet_management.management.infrastructure.adapter.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.app.micro_pet_management.management.domain.model.Pet;
import com.app.micro_pet_management.management.infrastructure.adapter.entity.PetEntity;

@Mapper
public interface PetMapper {

	@Mapping(ignore=true, target="id")
	PetEntity toEntity(Pet pet);
	
	Pet toDomain(PetEntity petEntity);
}
