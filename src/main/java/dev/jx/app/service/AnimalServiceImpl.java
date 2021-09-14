package dev.jx.app.service;

import java.util.Collection;
import java.util.Optional;

import dev.jx.app.entity.Area;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import dev.jx.app.entity.Animal;
import dev.jx.app.repository.AnimalRepository;

@Service
public class AnimalServiceImpl implements AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    @Override
    @Transactional(readOnly = true)
    public Collection<Animal> findAll() {
        return this.animalRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<Animal> findAllByAreasContaining(Area area) {
        return this.animalRepository.findAllByAreasContaining(area);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<Animal> findAllByAreasNotContaining(Area area) {
        return this.animalRepository.findAllByAreasNotContaining(area);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<Animal> findAllByAreasNotContainingAndIdNotIn(Area area, Collection<Integer> ids) {
        return this.animalRepository.findAllByAreasNotContainingAndIdNotIn(area, ids);
    }

    @Override
    @Transactional(readOnly = true)
    public Animal findById(Integer id) {
        return this.animalRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void insert(Animal animal) {
        this.animalRepository.save(animal);
    }

    @Override
    @Transactional
    public void update(Animal animal) {
        this.animalRepository.save(animal);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        this.animalRepository.deleteById(id);
    }
}