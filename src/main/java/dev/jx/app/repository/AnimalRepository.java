package dev.jx.app.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import dev.jx.app.entity.Animal;
import dev.jx.app.entity.Area;

public interface AnimalRepository extends JpaRepository<Animal, Integer> {

    List<Animal> findAllByAreasContaining(Area area);

    List<Animal> findAllByAreasNotContaining(Area area);

    List<Animal> findAllByAreasNotContainingAndIdNotIn(Area area, Collection<Integer> ids);
}
