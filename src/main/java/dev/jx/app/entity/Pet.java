package dev.jx.app.entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "pets")
public class Pet implements Serializable {

    @Id
    @Column(name = "pet_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "pet_age")
    private Integer age;

    @Column(name = "pet_name", nullable = false, unique = true)
    private String name;

    @Column(name = "pet_animal")
    private String animal;

    @Column(name = "pet_breed")
    private String breed;

    @Column(name = "pet_city")
    private String city;

    @Column(name = "pet_available_adoption")
    private Boolean availableAdoption;

    public Pet() {
    }

    public Pet(Integer id, Integer age, String name, String animal, String breed, String city, Boolean availableAdoption) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.animal = animal;
        this.breed = breed;
        this.city = city;
        this.availableAdoption = availableAdoption;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAnimal() {
        return animal;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Boolean getAvailableAdoption() {
        return availableAdoption;
    }

    public void setAvailableAdoption(Boolean availableAdoption) {
        this.availableAdoption = availableAdoption;
    }
}
