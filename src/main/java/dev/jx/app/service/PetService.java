package dev.jx.app.service;

import java.util.Collection;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import dev.jx.app.entity.Pet;

public interface PetService {

    Collection<Pet> findAll();

    default Page<Pet> findAll(Pageable pageable) {
        return Page.empty();
    }

    default Page<Pet> findAll(Example<Pet> example, Pageable pageable) {
        return Page.empty();
    }

    Pet findById(Integer id);

    Pet findByName(String name);

    void insert(Pet pet);

    void update(Pet pet);

    void deleteById(Integer id);
}
