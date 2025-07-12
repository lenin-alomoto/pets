package com.app.micro_pet_management.management.infrastructure.adapter;

import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Repository;

import com.app.micro_pet_management.management.domain.model.Pet;
import com.app.micro_pet_management.management.domain.repository.ManagePetRepositoryPort;
import com.app.micro_pet_management.management.infrastructure.adapter.mapper.PetMapper;
import com.app.micro_pet_management.management.infrastructure.adapter.repository.PetRespositoryJpa;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
@RequiredArgsConstructor
public class ManagerPetRespositoryAdapter implements ManagePetRepositoryPort {
	
	private PetMapper petMapper = Mappers.getMapper(PetMapper.class);

	private final PetRespositoryJpa petRespositoryJpa;
	
	@Override
	public Pet savePet(Pet pet) {
		return petMapper.toDomain(petRespositoryJpa.save(petMapper.toEntity(pet)));
	}

}
