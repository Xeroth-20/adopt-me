package dev.jx.app.service;

import java.util.Collection;

import dev.jx.app.entity.MedicalRecord;

public interface MedicalRecordService {

	Collection<MedicalRecord> findAll();

	MedicalRecord findById(Integer id);

	void insert(MedicalRecord medicalRecord);

	void update(MedicalRecord medicalRecord);

	void deleteById(Integer id);
}