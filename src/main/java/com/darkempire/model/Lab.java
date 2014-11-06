package com.darkempire.model;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Сергій on 06.11.2014.
 */
@Entity
@Table(name = "lab", schema = "public", catalog = "mips")
public class Lab {
    private int id;
    private String number;
    private String name;
    private Date deadline;
    private String description;
    private int maxPoint;
    private LabBundle labBundleByLabBundleId;

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
    @Column(name = "number", nullable = false, insertable = true, updatable = true, length = 8)
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Basic
    @Column(name = "name", nullable = false, insertable = true, updatable = true, length = 128)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "deadline", nullable = true, insertable = true, updatable = true)
    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    @Basic
    @Column(name = "description", nullable = false, insertable = true, updatable = true, length = 512)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "max_point", nullable = false, insertable = true, updatable = true)
    public int getMaxPoint() {
        return maxPoint;
    }

    public void setMaxPoint(int maxPoint) {
        this.maxPoint = maxPoint;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Lab lab = (Lab) o;

        if (id != lab.id) return false;
        if (maxPoint != lab.maxPoint) return false;
        if (deadline != null ? !deadline.equals(lab.deadline) : lab.deadline != null) return false;
        if (description != null ? !description.equals(lab.description) : lab.description != null) return false;
        if (name != null ? !name.equals(lab.name) : lab.name != null) return false;
        if (number != null ? !number.equals(lab.number) : lab.number != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (deadline != null ? deadline.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + maxPoint;
        return result;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lab_bundle_id", referencedColumnName = "id", nullable = false)
    public LabBundle getLabBundleByLabBundleId() {
        return labBundleByLabBundleId;
    }

    public void setLabBundleByLabBundleId(LabBundle labBundleByLabBundleId) {
        this.labBundleByLabBundleId = labBundleByLabBundleId;
    }
}
