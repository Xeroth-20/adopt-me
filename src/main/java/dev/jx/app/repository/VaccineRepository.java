package dev.jx.app.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import dev.jx.app.entity.Vaccine;

public interface VaccineRepository extends JpaRepository<Vaccine, Integer> {

    @Query(
            value = "SELECT v FROM Vaccine v " +
                    "WHERE ?1 NOT IN (SELECT d.medicalRecord.id FROM Dosage d WHERE d.id.vaccineId = v.id)"
    )
    List<Vaccine> findAllNotIncludedInMedicalRecordId(Integer id);

    @Query(
            value = "SELECT v FROM Vaccine v " +
                    "WHERE ?1 NOT IN (SELECT d.medicalRecord.id FROM Dosage d WHERE d.id.vaccineId = v.id) " +
                    "AND v.id NOT IN ?2"
    )
    List<Vaccine> findAllNotIncludedInMedicalRecordIdAndIdNotIn(Integer medicalRecordId, Collection<Integer> ids);
}
