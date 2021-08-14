package dev.jx.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import dev.jx.app.entity.Owner;

public interface OwnerRepository extends JpaRepository<Owner, Integer> {
}
