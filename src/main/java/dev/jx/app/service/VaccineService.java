package dev.jx.app.service;

import java.util.Collection;

import dev.jx.app.entity.Vaccine;

public interface VaccineService {

    Collection<Vaccine> findAll();

    Collection<Vaccine> findAllNotIncludedInMedicalRecordId(Integer id);

    Collection<Vaccine> findAllNotIncludedInMedicalRecordIdAndIdNotIn(Integer medicalRecordId, Collection<Integer> ids);

    Vaccine findById(Integer id);

    void insert(Vaccine vaccine);

    void update(Vaccine vaccine);

    void deleteById(Integer id);
}