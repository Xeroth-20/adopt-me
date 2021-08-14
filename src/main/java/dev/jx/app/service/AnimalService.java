package dev.jx.app.service;

import java.util.Collection;

import dev.jx.app.entity.Animal;

public interface AnimalService {

	Collection<Animal> findAll();

	Animal findById(Integer id);

	void insert(Animal animal);

	void update(Animal animal);

	void deleteById(Integer id);
}