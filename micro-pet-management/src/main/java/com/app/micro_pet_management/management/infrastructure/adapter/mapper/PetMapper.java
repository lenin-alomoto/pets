package com.app.micro_pet_management.management.infrastructure.adapter.mapper;

import org.mapstruct.Mapper;

import com.app.micro_pet_management.management.domain.model.Pet;
import com.app.micro_pet_management.management.infrastructure.adapter.entity.PetEntity;

@Mapper
public interface PetMapper {

	PetEntity toEntity(Pet pet);
	Pet toDomain(PetEntity petEntity);
}
