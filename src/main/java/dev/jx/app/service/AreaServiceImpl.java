package dev.jx.app.service;

import java.util.Collection;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import dev.jx.app.entity.Area;
import dev.jx.app.repository.AreaRepository;

@Service
public class AreaServiceImpl implements AreaService {

	@Autowired
	private AreaRepository areaRepository;

	@Override
	@Transactional(readOnly = true)
	public Collection<Area> findAll() {
		return this.areaRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Object[]> findAllAreasAnimals() {
		return this.areaRepository.findAllAreasAnimals();
	}

	@Override
	@Transactional(readOnly = true)
	public Area findById(Integer id) {
		return this.areaRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void insert(Area area) {
		this.areaRepository.save(area);
	}

	@Override
	@Transactional
	public void update(Area area) {
		this.areaRepository.save(area);
	}

	@Override
	@Transactional
	public void deleteById(Integer id) {
		this.areaRepository.deleteById(id);
	}
}