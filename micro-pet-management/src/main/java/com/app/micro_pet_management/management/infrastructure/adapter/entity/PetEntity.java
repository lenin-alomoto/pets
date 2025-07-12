package com.app.micro_pet_management.management.infrastructure.adapter.entity;

import com.app.micro_pet_management.management.domain.model.Measurement;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "pet")
@Getter
@Setter
public class PetEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private int age;
	
	private String adrres;
	
	private String city;
	
	@Column(name = "breed_group")
	private String breedGroup;
	
	@Column(name = "life_span")
	private String lifeSpan;
	
	@Embedded
	@AttributeOverrides({
	    @AttributeOverride(name = "imperial", column = @Column(name = "weight_imperial")),
	    @AttributeOverride(name = "metric", column = @Column(name = "weight_metric"))
	})
	private Measurement weight;

	@Embedded
	@AttributeOverrides({
	    @AttributeOverride(name = "imperial", column = @Column(name = "height_imperial")),
	    @AttributeOverride(name = "metric", column = @Column(name = "height_metric"))
	})
	private Measurement height;
	
	private String temperament;
	
	@Column(name = "bred_for")
	private String bredFor;

}
