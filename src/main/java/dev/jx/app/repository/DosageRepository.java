package dev.jx.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import dev.jx.app.entity.Dosage;
import dev.jx.app.entity.DosageId;

public interface DosageRepository extends JpaRepository<Dosage, DosageId> {
}
