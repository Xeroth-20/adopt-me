package dev.jx.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import dev.jx.app.entity.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Integer> {
}
