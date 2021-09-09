package dev.jx.app.entity;

import java.util.Objects;
import java.time.LocalDate;
import java.io.Serializable;
import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "dosages")
public class Dosage implements Serializable, Comparable<Dosage> {

    @EmbeddedId
    private DosageId id = new DosageId();

    @MapsId("medicalRecordId")
    @ManyToOne
    @JoinColumn(name = "mer_id", referencedColumnName = "mer_id")
    private MedicalRecord medicalRecord;

    @MapsId("vaccineId")
    @ManyToOne
    @JoinColumn(name = "vac_id", referencedColumnName = "vac_id")
    private Vaccine vaccine;

    @Column(name = "dos_method")
    private String method;

    @Column(name = "dos_quantity")
    private Double quantity;

    @Column(name = "dos_dosage_date")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern = "yyyy-MM-dd")
    private LocalDate dosageDate;

    public Dosage() {
    }

    @Override
    public int compareTo(Dosage o) {
        return vaccine.getId().compareTo(o.getVaccine().getId());
    }

    public Dosage(DosageId id) {
        this.id = id;
    }

    public DosageId getId() {
        return id;
    }

    public void setId(DosageId id) {
        this.id = id;
    }

    public MedicalRecord getMedicalRecord() {
        return medicalRecord;
    }

    public void setMedicalRecord(MedicalRecord medicalRecord) {
        this.medicalRecord = medicalRecord;
    }

    public Vaccine getVaccine() {
        return vaccine;
    }

    public void setVaccine(Vaccine vaccine) {
        this.vaccine = vaccine;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public LocalDate getDosageDate() {
        return dosageDate;
    }

    public void setDosageDate(LocalDate dosageDate) {
        this.dosageDate = dosageDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dosage dosage = (Dosage) o;
        return Objects.equals(id, dosage.id) && Objects.equals(method, dosage.method) && Objects.equals(quantity, dosage.quantity) && Objects.equals(dosageDate, dosage.dosageDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, method, quantity, dosageDate);
    }
}
