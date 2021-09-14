package dev.jx.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import dev.jx.app.entity.Pet;

public interface PetRepository extends JpaRepository<Pet, Integer> {

    @Query(value = "SELECT * FROM pets p WHERE p.pet_name = ?1", nativeQuery = true)
    Optional<Pet> findByName(String name);
}
