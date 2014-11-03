package com.darkempire.model;

import javax.persistence.*;
import java.sql.Time;

/**
 * Created by Сергій on 03.11.2014.
 */
@Entity
@Table(name = "submit_try", schema = "public", catalog = "mips")
public class SubmitTry {
    private int id;
    private Time time;
    private float points;
    private boolean teacherChecked;
    private int testPassed;
    private Student studentByStudentId;
    private Variant variantByVariantId;

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
    @Column(name = "time", nullable = false, insertable = true, updatable = true)
    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    @Basic
    @Column(name = "points", nullable = false, insertable = true, updatable = true, precision = 8)
    public float getPoints() {
        return points;
    }

    public void setPoints(float points) {
        this.points = points;
    }

    @Basic
    @Column(name = "teacher_checked", nullable = false, insertable = true, updatable = true)
    public boolean isTeacherChecked() {
        return teacherChecked;
    }

    public void setTeacherChecked(boolean teacherChecked) {
        this.teacherChecked = teacherChecked;
    }

    @Basic
    @Column(name = "test_passed", nullable = false, insertable = true, updatable = true)
    public int getTestPassed() {
        return testPassed;
    }

    public void setTestPassed(int testPassed) {
        this.testPassed = testPassed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SubmitTry submitTry = (SubmitTry) o;

        if (id != submitTry.id) return false;
        if (Float.compare(submitTry.points, points) != 0) return false;
        if (teacherChecked != submitTry.teacherChecked) return false;
        if (testPassed != submitTry.testPassed) return false;
        if (time != null ? !time.equals(submitTry.time) : submitTry.time != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (points != +0.0f ? Float.floatToIntBits(points) : 0);
        result = 31 * result + (teacherChecked ? 1 : 0);
        result = 31 * result + testPassed;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id", nullable = false)
    public Student getStudentByStudentId() {
        return studentByStudentId;
    }

    public void setStudentByStudentId(Student studentByStudentId) {
        this.studentByStudentId = studentByStudentId;
    }

    @ManyToOne
    @JoinColumn(name = "variant_id", referencedColumnName = "id", nullable = false)
    public Variant getVariantByVariantId() {
        return variantByVariantId;
    }

    public void setVariantByVariantId(Variant variantByVariantId) {
        this.variantByVariantId = variantByVariantId;
    }
}
