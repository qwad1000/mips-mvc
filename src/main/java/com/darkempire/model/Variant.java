package com.darkempire.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Сергій on 03.11.2014.
 */
@Entity
@Table(name = "variant", schema = "public", catalog = "mips")
public class Variant {
    private int id;
    private String mission;
    private Collection<Lab> labsById;
    private Collection<SubmitTry> submitTriesById;
    private Collection<Test> testsById;

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "mission", nullable = false, insertable = true, updatable = true, length = 2147483647)
    public String getMission() {
        return mission;
    }

    public void setMission(String mission) {
        this.mission = mission;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Variant variant = (Variant) o;

        if (id != variant.id) return false;
        if (mission != null ? !mission.equals(variant.mission) : variant.mission != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (mission != null ? mission.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "variantByVariantId")
    public Collection<Lab> getLabsById() {
        return labsById;
    }

    public void setLabsById(Collection<Lab> labsById) {
        this.labsById = labsById;
    }

    @OneToMany(mappedBy = "variantByVariantId")
    public Collection<SubmitTry> getSubmitTriesById() {
        return submitTriesById;
    }

    public void setSubmitTriesById(Collection<SubmitTry> submitTriesById) {
        this.submitTriesById = submitTriesById;
    }

    @OneToMany(mappedBy = "variantByVariantId")
    public Collection<Test> getTestsById() {
        return testsById;
    }

    public void setTestsById(Collection<Test> testsById) {
        this.testsById = testsById;
    }
}
