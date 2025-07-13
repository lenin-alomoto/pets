package com.app.micro_pet_management.management.infrastructure.adapter;

import java.util.List;
import java.util.stream.Collectors;

import org.mapstruct.factory.Mappers;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import com.app.micro_pet_management.management.domain.model.Pet;
import com.app.micro_pet_management.management.domain.model.PetFilter;
import com.app.micro_pet_management.management.domain.repository.ManagePetRepositoryPort;
import com.app.micro_pet_management.management.infrastructure.adapter.entity.PetEntity;
import com.app.micro_pet_management.management.infrastructure.adapter.mapper.PetMapper;
import com.app.micro_pet_management.management.infrastructure.adapter.repository.PetRespositoryJpa;
import com.app.micro_pet_management.management.infrastructure.adapter.specification.PetSpecificationBuilder;

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

	@Override
	public List<Pet> findAllByFilters(PetFilter petFilter) {
		Specification<PetEntity> specificationFilter = PetSpecificationBuilder.build(petFilter);
		log.info("Filter: {}", specificationFilter.toString());
        List<PetEntity> results = petRespositoryJpa.findAll(specificationFilter);
        return results.stream()
                      .map(petMapper::toDomain)
                      .collect(Collectors.toList());
	}
	
}
