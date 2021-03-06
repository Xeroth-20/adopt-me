package dev.jx.app.service;

import java.util.Collection;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import dev.jx.app.entity.Vaccine;
import dev.jx.app.repository.VaccineRepository;

@Service
public class VaccineServiceImpl implements VaccineService {

    @Autowired
    private VaccineRepository vaccineRepository;

    @Override
    @Transactional(readOnly = true)
    public Collection<Vaccine> findAll() {
        return this.vaccineRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<Vaccine> findAllNotIncludedInMedicalRecordId(Integer id) {
        return this.vaccineRepository.findAllNotIncludedInMedicalRecordId(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<Vaccine> findAllNotIncludedInMedicalRecordIdAndIdNotIn(Integer medicalRecordId, Collection<Integer> ids) {
        return this.vaccineRepository.findAllNotIncludedInMedicalRecordIdAndIdNotIn(medicalRecordId, ids);
    }

    @Override
    @Transactional(readOnly = true)
    public Vaccine findById(Integer id) {
        return this.vaccineRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void insert(Vaccine vaccine) {
        this.vaccineRepository.save(vaccine);
    }

    @Override
    @Transactional
    public void update(Vaccine vaccine) {
        this.vaccineRepository.save(vaccine);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        this.vaccineRepository.deleteById(id);
    }
}