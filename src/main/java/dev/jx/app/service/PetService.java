package dev.jx.app.service;

import dev.jx.app.entity.Pet;

import java.util.Collection;

public interface PetService {

    public Collection<Pet> findAll();

    public Pet findById(Integer id);

    public void insert(Pet object);

    public void update(Pet object);

    public void deleteById(Integer id);
}
