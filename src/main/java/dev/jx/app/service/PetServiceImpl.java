package dev.jx.app.service;

import java.util.Collection;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import dev.jx.app.entity.Pet;
import dev.jx.app.repository.PetRepository;

@Service
public class PetServiceImpl implements PetService {

    @Autowired
    @Qualifier("petRepositoryImpl")
    private PetRepository petRepository;

    @Override
    public Collection<Pet> findAll() {
        return this.petRepository.findAll();
    }

    @Override
    public Pet findById(Integer id) {
        return this.petRepository.findById(id);
    }

    @Override
    public void insert(Pet object) {
        this.petRepository.insert(object);
    }

    @Override
    public void update(Pet object) {
        this.petRepository.update(object);
    }

    @Override
    public void deleteById(Integer id) {
        this.petRepository.deleteById(id);
    }
}
