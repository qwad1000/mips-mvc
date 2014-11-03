package com.darkempire.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

/**
 * Created by Сергій on 27.10.2014.
 */
@Entity
@Table(name = "users", schema = "public", catalog = "mips")
public class User {
    private int id;
    private String email;
    private String password;
    private boolean enabled;
    private Set<UserRole> userRolesById;
    private Collection<Student> studentsById;
    private Collection<UserRole> userRolesesById;

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
    @Column(name = "email", nullable = true, insertable = true, updatable = true, length = 100)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "password", nullable = true, insertable = true, updatable = true, length = 100)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "enabled", nullable = false, insertable = true, updatable = true)
    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (enabled != user.enabled) return false;
        if (id != user.id) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (enabled ? 1 : 0);
        return result;
    }

    @OneToMany(mappedBy = "usersByUserId", fetch = FetchType.EAGER)
    public Set<UserRole> getUserRolesById() {
        return userRolesById;
    }

    public void setUserRolesById(Set<UserRole> userRolesesById) {
        this.userRolesById = userRolesesById;
    }

    @OneToMany(mappedBy = "usersByUserId")
    public Collection<Student> getStudentsById() {
        return studentsById;
    }

    public void setStudentsById(Collection<Student> studentsById) {
        this.studentsById = studentsById;
    }

    @OneToMany(mappedBy = "usersByUserId")
    public Collection<UserRole> getUserRolesesById() {
        return userRolesesById;
    }

    public void setUserRolesesById(Collection<UserRole> userRolesesById) {
        this.userRolesesById = userRolesesById;
    }
}
