package dev.jx.app.entity;

import java.util.Base64;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "images")
public class Image implements Serializable {

    @Id
    @Column(name = "img_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(mappedBy = "image")
    private Pet pet;

    @Column(name = "img_name")
    private String name;

    @Column(name = "img_data", columnDefinition = "longblob")
    private byte[] data;

    public Image() {
    }

    public String getSrc() {
        return "data:image/" + name.substring(name.indexOf(".") + 1) +
                ";charset=utf-8;base64," +
                Base64.getEncoder().encodeToString(data);
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
