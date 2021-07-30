package dev.jx.app.service;

import dev.jx.app.entity.Pet;

import java.util.Collection;

public interface PetService {

    Collection<Pet> findAll();

    Pet findById(Integer id);

    Pet findByName(String name);

    void insert(Pet pet);

    void update(Pet pet);

    void deleteById(Integer id);
}
