package dev.jx.app.service;

import java.util.Collection;
import java.time.LocalDate;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import dev.jx.app.entity.Adoption;
import dev.jx.app.repository.AdoptionRepository;

@Service
public class AdoptionServiceImpl implements AdoptionService {

	@Autowired
	private AdoptionRepository adoptionRepository;

	@Override
	@Transactional(readOnly = true)
	public Collection<Adoption> findAll() {
		return this.adoptionRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Adoption findById(Integer id) {
		return this.adoptionRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void insert(Adoption adoption) {
		adoption.setAdoptionDate(LocalDate.now());
		this.adoptionRepository.save(adoption);
	}

	@Override
	@Transactional
	public void update(Adoption adoption) {
		this.adoptionRepository.save(adoption);
	}

	@Override
	@Transactional
	public void deleteById(Integer id) {
		this.adoptionRepository.deleteById(id);
	}
}