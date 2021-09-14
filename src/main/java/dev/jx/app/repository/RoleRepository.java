package dev.jx.app.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import dev.jx.app.entity.Role;
import dev.jx.app.entity.User;

public interface RoleRepository extends JpaRepository<Role, Integer> {

    List<Role> findAllByUsersContains(User user);

    Collection<Role> findAllByUsersNotContains(User user);
}
