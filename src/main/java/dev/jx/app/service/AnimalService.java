package dev.jx.app.service;

import java.util.Collection;

import dev.jx.app.entity.Animal;
import dev.jx.app.entity.Area;

public interface AnimalService {

	Collection<Animal> findAll();

	Collection<Animal> findAllByAreasNotContaining(Area area);

	Animal findById(Integer id);

	void insert(Animal animal);

	void update(Animal animal);

	void deleteById(Integer id);
}