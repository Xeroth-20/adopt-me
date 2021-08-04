package dev.jx.app.entity;

import java.time.LocalDate;
import java.io.Serializable;
import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "adoptions")
public class Adoption implements Serializable {

    @Id
    @Column(name = "ado_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(optional = false)
    @JoinColumn(name = "pet_id", referencedColumnName = "pet_id", unique = true)
    private Pet pet;

    @ManyToOne(optional = false)
    @JoinColumn(name = "own_id", referencedColumnName = "own_id")
    private Owner owner;

    @Column(name = "ado_adoption_date")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern = "yyyy-MM-dd")
    private LocalDate adoptionDate;

    public Adoption() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public LocalDate getAdoptionDate() {
        return adoptionDate;
    }

    public void setAdoptionDate(LocalDate adoptionDate) {
        this.adoptionDate = adoptionDate;
    }
}
