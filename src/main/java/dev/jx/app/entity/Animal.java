package dev.jx.app.entity;

import java.util.Collection;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "animals")
public class Animal implements Serializable {

    @Id
    @Column(name = "ani_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(mappedBy = "animal")
    private Collection<Pet> pets;

    @Column(name = "ani_name")
    private String name;

    public Animal() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
