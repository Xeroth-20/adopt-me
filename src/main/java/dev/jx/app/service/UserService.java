package dev.jx.app.service;

import java.util.Collection;

import org.springframework.security.core.userdetails.UserDetailsService;
import dev.jx.app.entity.User;

public interface UserService extends UserDetailsService {

    Collection<User> findAll();

    User findById(Integer id);

    boolean existsByUsername(String username);

    void insert(User user);

    void update(User user);

    void deleteById(Integer id);
}
