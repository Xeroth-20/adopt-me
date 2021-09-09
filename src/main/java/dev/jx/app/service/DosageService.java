package dev.jx.app.service;

import java.util.Collection;

import dev.jx.app.entity.Dosage;
import dev.jx.app.entity.DosageId;

public interface DosageService {

    Collection<Dosage> findAll();

    Dosage findById(DosageId id);

    void insert(Dosage dosage);

    void insertAll(Collection<Dosage> dosages);

    void update(Dosage dosage);

    void deleteById(DosageId id);
}
