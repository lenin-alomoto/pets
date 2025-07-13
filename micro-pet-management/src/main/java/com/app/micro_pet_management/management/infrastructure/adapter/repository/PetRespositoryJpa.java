package com.app.micro_pet_management.management.infrastructure.adapter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.app.micro_pet_management.management.infrastructure.adapter.entity.PetEntity;

public interface PetRespositoryJpa extends JpaRepository<PetEntity, Long>, JpaSpecificationExecutor<PetEntity> {

}
