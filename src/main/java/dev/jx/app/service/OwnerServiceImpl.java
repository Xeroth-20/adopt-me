package dev.jx.app.service;

import java.util.Collection;
import java.time.LocalDate;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import dev.jx.app.entity.Owner;
import dev.jx.app.repository.OwnerRepository;

@Service
public class OwnerServiceImpl implements OwnerService {

    @Autowired
    private OwnerRepository ownerRepository;

    @Override
    @Transactional(readOnly = true)
    public Collection<Owner> findAll() {
        return this.ownerRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Owner findById(Integer id) {
        return this.ownerRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void insert(Owner owner) {
        owner.setRegistrationDate(LocalDate.now());
        this.ownerRepository.save(owner);
    }

    @Override
    @Transactional
    public void update(Owner owner) {
        this.ownerRepository.save(owner);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        this.ownerRepository.deleteById(id);
    }
}