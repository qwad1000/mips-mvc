package com.darkempire.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Сергій on 03.11.2014.
 */
@Entity
@Table(name = "student", schema = "public", catalog = "mips")
public class Student {
    private int id;
    private String name;
    private StudentsGroup studentsGroupByGroupId;
    private User usersByUserId;
    private Collection<SubmitTry> submitTriesById;

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
    @Column(name = "name", nullable = false, insertable = true, updatable = true, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (id != student.id) return false;
        if (name != null ? !name.equals(student.name) : student.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "group_id", referencedColumnName = "id", nullable = false)
    public StudentsGroup getStudentsGroupByGroupId() {
        return studentsGroupByGroupId;
    }

    public void setStudentsGroupByGroupId(StudentsGroup studentsGroupByGroupId) {
        this.studentsGroupByGroupId = studentsGroupByGroupId;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    public User getUsersByUserId() {
        return usersByUserId;
    }

    public void setUsersByUserId(User usersByUserId) {
        this.usersByUserId = usersByUserId;
    }

    @OneToMany(mappedBy = "studentByStudentId")
    public Collection<SubmitTry> getSubmitTriesById() {
        return submitTriesById;
    }

    public void setSubmitTriesById(Collection<SubmitTry> submitTriesById) {
        this.submitTriesById = submitTriesById;
    }
}
