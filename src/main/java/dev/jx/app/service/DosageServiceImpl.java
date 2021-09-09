package dev.jx.app.service;

import java.util.Collection;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import dev.jx.app.entity.Dosage;
import dev.jx.app.entity.DosageId;
import dev.jx.app.repository.DosageRepository;

@Service
public class DosageServiceImpl implements DosageService {

    @Autowired
    private DosageRepository dosageRepository;

    @Override
    @Transactional(readOnly = true)
    public Collection<Dosage> findAll() {
        return this.dosageRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Dosage findById(DosageId id) {
        return this.dosageRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void insert(Dosage dosage) {
        this.dosageRepository.save(dosage);
    }

    @Override
    @Transactional
    public void insertAll(Collection<Dosage> dosages) {
        this.dosageRepository.saveAll(dosages);
    }

    @Override
    @Transactional
    public void update(Dosage dosage) {
        this.dosageRepository.save(dosage);
    }

    @Override
    @Transactional
    public void deleteById(DosageId id) {
        this.dosageRepository.deleteById(id);
    }
}
