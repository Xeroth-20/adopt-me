package dev.jx.app.service;

import java.util.Collection;

import dev.jx.app.entity.Owner;

public interface OwnerService {

	Collection<Owner> findAll();

	Owner findById(Integer id);

	void insert(Owner owner);

	void update(Owner owner);

	void deleteById(Integer id);
}