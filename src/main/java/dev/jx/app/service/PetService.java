package dev.jx.app.service;

import java.util.Collection;

import dev.jx.app.entity.Pet;

public interface PetService {

    Collection<Pet> findAll();

    Pet findById(Integer id);

    Pet findByName(String name);

    void insert(Pet pet);

    void update(Pet pet);

    void deleteById(Integer id);
}
