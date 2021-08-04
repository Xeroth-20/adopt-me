package dev.jx.app.service;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;
import java.time.LocalDate;

import org.springframework.stereotype.Service;
import org.springframework.context.annotation.Profile;
import dev.jx.app.entity.Pet;

@Service
@Profile("development")
public class PetServiceMemory implements PetService {

    private static final Map<Integer, Pet> db = new TreeMap<>();

    static {
        Pet pet1 = new Pet(1, "Luna", 2, true, LocalDate.of(2021, 7, 30));
        Pet pet2 = new Pet(2, "Olive", 1, true, LocalDate.of(2021, 7, 30));
        Pet pet3 = new Pet(3, "Sudo", 3, false, LocalDate.of(2021, 7, 30));
        Pet pet4 = new Pet(4, "Lyda", 2, true, LocalDate.of(2021, 7, 30));
        Pet pet5 = new Pet(5, "Vera", 4, false, LocalDate.of(2021, 7, 30));
        db.put(pet1.getId(), pet1);
        db.put(pet2.getId(), pet2);
        db.put(pet3.getId(), pet3);
        db.put(pet4.getId(), pet4);
        db.put(pet5.getId(), pet5);
    }

    @Override
    public Collection<Pet> findAll() {
        return db.values();
    }

    @Override
    public Pet findById(Integer id) {
        return db.get(id);
    }

    @Override
    public Pet findByName(String name) {
        return db.values().stream().filter((Pet pet) -> pet.getName().equals(name)).findFirst().orElse(null);
    }

    @Override
    public void insert(Pet pet) {
        pet.setId(db.size() + 1);
        pet.setRegistrationDate(LocalDate.now());
        db.put(pet.getId(), pet);
    }

    @Override
    public void update(Pet pet) {
        db.replace(pet.getId(), pet);
    }

    @Override
    public void deleteById(Integer id) {
        db.remove(id);
    }
}
