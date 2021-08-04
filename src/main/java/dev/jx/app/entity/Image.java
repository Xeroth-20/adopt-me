package dev.jx.app.entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "images")
public class Image implements Serializable {

    @Id
    @Column(name = "img_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "img_name")
    private String name;

    @Column(name = "img_data", columnDefinition = "longblob")
    private byte[] data;

    public Image() {
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

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
