package dev.jx.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import dev.jx.app.entity.Vaccine;

public interface VaccineRepository extends JpaRepository<Vaccine, Integer> {

    @Query(
            value = "SELECT v FROM Vaccine v " +
                    "LEFT JOIN FETCH v.dosages d " +
                    "WHERE d.id.medicalRecordId IS NULL OR d.id.medicalRecordId <> ?1"
    )
    List<Vaccine> findAllNotIncludedInMedicalRecord(Integer id);
}
