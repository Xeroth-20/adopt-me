package dev.jx.app.service;

import java.util.Collection;

import dev.jx.app.entity.Adoption;

public interface AdoptionService {

	Collection<Adoption> findAll();

	Adoption findById(Integer id);

	void insert(Adoption adoption);

	void update(Adoption adoption);

	void deleteById(Integer id);
}