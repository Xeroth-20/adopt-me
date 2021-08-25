package dev.jx.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import dev.jx.app.entity.Image;

public interface ImageRepository extends JpaRepository<Image, Integer> {

    List<Image> findAllByPetIsNull();
}
