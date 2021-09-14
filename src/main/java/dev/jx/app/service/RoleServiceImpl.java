package dev.jx.app.service;

import java.util.Collection;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import dev.jx.app.entity.Role;
import dev.jx.app.entity.User;
import dev.jx.app.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    @Transactional(readOnly = true)
    public Collection<Role> findAll() {
        return this.roleRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<Role> findAllByUsersContains(User user) {
        return this.roleRepository.findAllByUsersContains(user);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<Role> findAllByUsersNotContains(User user) {
        return this.roleRepository.findAllByUsersNotContains(user);
    }

    @Override
    @Transactional(readOnly = true)
    public Role findById(Integer id) {
        return this.roleRepository.findById(id).orElse(null);
    }
}
