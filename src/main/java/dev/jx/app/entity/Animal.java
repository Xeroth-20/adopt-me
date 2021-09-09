package dev.jx.app.entity;

import java.util.*;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "animals")
public class Animal implements Serializable, Comparable<Animal> {

    @Id
    @Column(name = "ani_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(mappedBy = "animal")
    private Collection<Pet> pets = new ArrayList<>();

    @ManyToMany(mappedBy = "animals")
    private Set<Area> areas = new HashSet<>();

    @Column(name = "ani_name")
    private String name;

    public Animal() {
    }

    @Override
    public int compareTo(Animal o) {
        return id.compareTo(o.getId());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Collection<Pet> getPets() {
        return pets;
    }

    public void setPets(Collection<Pet> pets) {
        this.pets = pets;
    }

    public Set<Area> getAreas() {
        return areas;
    }

    public void setAreas(Set<Area> areas) {
        this.areas = areas;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Objects.equals(id, animal.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
