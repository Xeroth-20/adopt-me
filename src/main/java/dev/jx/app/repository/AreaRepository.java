package dev.jx.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import dev.jx.app.entity.Area;

public interface AreaRepository extends JpaRepository<Area, Integer> {

    @Query(
            value = "SELECT are.are_id, are.are_name, ani.ani_id, ani.ani_name " +
                    "FROM areas_animals aa " +
                    "INNER JOIN areas are on aa.are_id = are.are_id " +
                    "INNER JOIN animals ani on aa.ani_id = ani.ani_id " +
                    "ORDER BY are.are_id, ani.ani_id",
            nativeQuery = true
    )
    List<Object[]> findAllAreasAnimals();
}
