package dev.jx.app.service;

import java.util.Collection;
import java.time.LocalDate;

import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.context.annotation.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import dev.jx.app.entity.Pet;
import dev.jx.app.repository.PetRepository;

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
    public Page<Pet> findAll(Pageable pageable) {
        return this.petRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Pet> findAll(Example<Pet> example, Pageable pageable) {
        return this.petRepository.findAll(example, pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Pet findById(Integer id) {
        return this.petRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Pet findByName(String name) {
        return this.petRepository.findByName(name).orElse(null);
    }

    @Override
    @Transactional
    public void insert(Pet pet) {
        pet.setRegistrationDate(LocalDate.now());
        this.petRepository.save(pet);
    }

    @Override
    @Transactional
    public void update(Pet pet) {
        this.petRepository.save(pet);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        this.petRepository.deleteById(id);
    }
}
