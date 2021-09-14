package dev.jx.app.service;

import java.util.Collection;

import dev.jx.app.entity.Role;
import dev.jx.app.entity.User;

public interface RoleService {

    Collection<Role> findAll();

    Collection<Role> findAllByUsersContains(User user);

    Collection<Role> findAllByUsersNotContains(User user);

    Role findById(Integer id);
}
