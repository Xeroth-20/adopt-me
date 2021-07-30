package dev.jx.app.entity;

import java.time.LocalDate;
import java.io.Serializable;
import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "pets")
public class Pet implements Serializable {

    @Id
    @Column(name = "pet_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "img_id", referencedColumnName = "img_id", unique = true)
    private Image image;

    @Column(name = "pet_name", nullable = false, unique = true)
    private String name;

    @Column(name = "pet_age")
    private Integer age;

    @Column(name = "pet_animal")
    private String animal;

    @Column(name = "pet_breed")
    private String breed;

    @Column(name = "pet_available_adoption")
    private Boolean availableAdoption;

    @Column(name = "pet_registration_date")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern = "yyyy-MM-dd")
    private LocalDate registrationDate;

    public Pet() {
    }

    public Pet(Integer id, String name, Integer age, String animal, String breed, Boolean availableAdoption, LocalDate registrationDate) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.animal = animal;
        this.breed = breed;
        this.availableAdoption = availableAdoption;
        this.registrationDate = registrationDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
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

    public Boolean getAvailableAdoption() {
        return availableAdoption;
    }

    public void setAvailableAdoption(Boolean availableAdoption) {
        this.availableAdoption = availableAdoption;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }
}
