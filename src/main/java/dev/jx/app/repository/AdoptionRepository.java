package dev.jx.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import dev.jx.app.entity.Adoption;

public interface AdoptionRepository extends JpaRepository<Adoption, Integer> {
}