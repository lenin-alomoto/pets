package com.app.micro_pet_management.management.infrastructure.adapter.specification;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import com.app.micro_pet_management.management.domain.model.PetFilter;
import com.app.micro_pet_management.management.infrastructure.adapter.entity.PetEntity;

import jakarta.persistence.criteria.Predicate;

public class PetSpecificationBuilder {
	
	private PetSpecificationBuilder() {
		throw new IllegalStateException("Utility class");
	}
	
	public static Specification<PetEntity> build(PetFilter filters) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (filters.getBreed() != null) {
                predicates.add(cb.like(cb.lower(root.get("breed")), "%" + filters.getBreed().toLowerCase() + "%"));
            }

            if (filters.getBreedGroup() != null) {
                predicates.add(cb.equal(cb.lower(root.get("breedGroup")), filters.getBreedGroup().toLowerCase()));
            }

            if (filters.getMinAge() != null) {
                predicates.add(cb.greaterThanOrEqualTo(root.get("age"), filters.getMinAge()));
            }

            if (filters.getMaxAge() != null) {
                predicates.add(cb.lessThanOrEqualTo(root.get("age"), filters.getMaxAge()));
            }

            if (filters.getMinWeight() != null) {
                predicates.add(cb.greaterThanOrEqualTo(root.get("minWeight"), filters.getMinWeight()));
            }

            if (filters.getMaxWeight() != null) {
                predicates.add(cb.lessThanOrEqualTo(root.get("maxWeight"), filters.getMaxWeight()));
            }

            if (filters.getMinHeight() != null) {
                predicates.add(cb.greaterThanOrEqualTo(root.get("minHeight"), filters.getMinHeight()));
            }

            if (filters.getMaxHeight() != null) {
                predicates.add(cb.lessThanOrEqualTo(root.get("maxHeight"), filters.getMaxHeight()));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
