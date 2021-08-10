package dev.jx.app.entity;

import java.util.Set;
import java.util.HashSet;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "vaccines")
public class Vaccine implements Serializable {

    @Id
    @Column(name = "vac_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(mappedBy = "vaccine")
    private Set<Dosage> dosages = new HashSet<>();

    @Column(name = "vac_name")
    private String name;

    @Column(name = "vac_description")
    private String description;

    public Vaccine() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<Dosage> getDosages() {
        return dosages;
    }

    public void setDosages(Set<Dosage> dosages) {
        this.dosages = dosages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
