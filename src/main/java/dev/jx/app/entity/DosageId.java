package dev.jx.app.entity;

import java.util.Objects;
import java.io.Serializable;
import javax.persistence.Embeddable;

@Embeddable
public class DosageId implements Serializable {

    private Integer medicalRecordId;

    private Integer vaccineId;

    public DosageId() {
    }

    public Integer getMedicalRecordId() {
        return medicalRecordId;
    }

    public void setMedicalRecordId(Integer medicalRecordId) {
        this.medicalRecordId = medicalRecordId;
    }

    public Integer getVaccineId() {
        return vaccineId;
    }

    public void setVaccineId(Integer vaccineId) {
        this.vaccineId = vaccineId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DosageId dosageId = (DosageId) o;
        return medicalRecordId.equals(dosageId.medicalRecordId) && vaccineId.equals(dosageId.vaccineId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(medicalRecordId, vaccineId);
    }
}
