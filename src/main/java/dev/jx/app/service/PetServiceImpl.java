package dev.jx.app.service;

import java.util.Collection;

import org.springframework.stereotype.Service;
import org.springframework.context.annotation.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import dev.jx.app.entity.Pet;
import dev.jx.app.repository.PetRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Profile("production")
public class PetServiceImpl implements PetService {

    @Autowired
    private PetRepository petRepository;

    @Override
    @Transactional(readOnly = true)
    public Collection<Pet> findAll() {
        return this.petRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Pet findById(Integer id) {
        return this.petRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Pet findByName(String name) {
        return this.petRepository.findByName(name);
    }

    @Override
    @Transactional
    public void insert(Pet object) {
        this.petRepository.save(object);
    }

    @Override
    @Transactional
    public void update(Pet object) {
        this.petRepository.save(object);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        this.petRepository.deleteById(id);
    }
}
