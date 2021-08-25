package dev.jx.app.entity;

import java.util.Collection;
import java.util.ArrayList;
import java.time.LocalDate;
import java.io.Serializable;
import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "owners")
public class Owner implements Serializable {

    @Id
    @Column(name = "own_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(mappedBy = "owner")
    private Collection<Adoption> adoptions = new ArrayList<>();

    @Column(name = "own_firstname")
    private String firstname;

    @Column(name = "own_lastname")
    private String lastname;

    @Column(name = "own_age")
    private Integer age;

    @Column(name = "own_email")
    private String email;

    @Column(name = "own_phone")
    private String phone;

    @Column(name = "own_address")
    private String address;

    @Column(name = "own_registration_date")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern = "yyyy-MM-dd")
    private LocalDate registrationDate;

    public Owner() {
    }

    public String getFullname() {
        return firstname + " " + lastname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Collection<Adoption> getAdoptions() {
        return adoptions;
    }

    public void setAdoptions(Collection<Adoption> adoptions) {
        this.adoptions = adoptions;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }
}
