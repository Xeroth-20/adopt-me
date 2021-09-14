package dev.jx.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import dev.jx.app.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUsername(String username);

    boolean existsByUsername(String username);
}
