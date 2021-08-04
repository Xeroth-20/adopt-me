package dev.jx.app.entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "areas")
public class Area implements Serializable {

    @Id
    @Column(name = "are_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "are_name")
    private String name;

    @Column(name = "are_square_meters")
    private Double squareMeters;

    public Area() {
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

    public Double getSquareMeters() {
        return squareMeters;
    }

    public void setSquareMeters(Double squareMeters) {
        this.squareMeters = squareMeters;
    }
}
