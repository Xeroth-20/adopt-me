package dev.jx.app.repository;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.stereotype.Repository;
import dev.jx.app.entity.Pet;

@Repository
public class PetRepositoryImpl implements PetRepository {

    private static final Map<Integer, Pet> db = new TreeMap<>();

    static {
        Pet pet1 = new Pet(1, 2, "Luna", "Dog", "Havanese", "Seattle", true);
        Pet pet2 = new Pet(2, 1, "Olive", "Dog", "Boxer", "Utah", true);
        Pet pet3 = new Pet(3, 3, "Sudo", "Dog", "Wheaten Terrier", "Denver", false);
        Pet pet4 = new Pet(4, 2, "Lyda", "Rabbit", "American", "Springfield", true);
        Pet pet5 = new Pet(5, 4, "Vera", "Cat", "Charteux", "Minneapolis", false);
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
    public void insert(Pet object) {
        object.setId(db.size() + 1);
        db.put(object.getId(), object);
    }

    @Override
    public void update(Pet object) {
        db.replace(object.getId(), object);
    }

    @Override
    public void deleteById(Integer id) {
        db.remove(id);
    }
}
