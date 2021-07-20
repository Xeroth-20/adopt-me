package dev.jx.app.repository;

import java.util.Collection;

import dev.jx.app.entity.Pet;

public interface PetRepository {

    public Collection<Pet> findAll();

    public Pet findById(Integer id);

    public void insert(Pet object);

    public void update(Pet object);

    public void deleteById(Integer id);
}
