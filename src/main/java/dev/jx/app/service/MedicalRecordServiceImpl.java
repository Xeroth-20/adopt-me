package dev.jx.app.service;

import java.util.Collection;
import java.time.LocalDate;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import dev.jx.app.entity.MedicalRecord;
import dev.jx.app.repository.MedicalRecordRepository;

@Service
public class MedicalRecordServiceImpl implements MedicalRecordService {

	@Autowired
	private MedicalRecordRepository medicalRecordRepository;

	@Override
	@Transactional(readOnly = true)
	public Collection<MedicalRecord> findAll() {
		return this.medicalRecordRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public MedicalRecord findById(Integer id) {
		return this.medicalRecordRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void insert(MedicalRecord medicalRecord) {
		medicalRecord.setCreationDate(LocalDate.now());
		this.medicalRecordRepository.save(medicalRecord);
	}

	@Override
	@Transactional
	public void update(MedicalRecord medicalRecord) {
		this.medicalRecordRepository.save(medicalRecord);
	}

	@Override
	@Transactional
	public void deleteById(Integer id) {
		this.medicalRecordRepository.deleteById(id);
	}
}