package com.darkempire.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Сергій on 03.11.2014.
 */
@Entity
@Table(name = "lab_bundle", schema = "public", catalog = "mips")
public class LabBundle {
    private int id;
    private String descriprion;
    private Collection<Lab> labsById;

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
    @Column(name = "descriprion", nullable = false, insertable = true, updatable = true, length = 2147483647)
    public String getDescriprion() {
        return descriprion;
    }

    public void setDescriprion(String descriprion) {
        this.descriprion = descriprion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LabBundle labBundle = (LabBundle) o;

        if (id != labBundle.id) return false;
        if (descriprion != null ? !descriprion.equals(labBundle.descriprion) : labBundle.descriprion != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (descriprion != null ? descriprion.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "labBundleByLabBundleId")
    public Collection<Lab> getLabsById() {
        return labsById;
    }

    public void setLabsById(Collection<Lab> labsById) {
        this.labsById = labsById;
    }
}
