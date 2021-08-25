package dev.jx.app.service;

import java.util.Collection;

import dev.jx.app.entity.Area;

public interface AreaService {

	Collection<Area> findAll();

	Area findById(Integer id);

	void insert(Area area);

	void update(Area area);

	void deleteById(Integer id);
}