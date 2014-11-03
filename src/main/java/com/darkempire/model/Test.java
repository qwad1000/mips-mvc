package com.darkempire.model;

import javax.persistence.*;

/**
 * Created by Сергій on 03.11.2014.
 */
@Entity
@Table(name = "test", schema = "public", catalog = "mips")
public class Test {
    private int id;
    private String body;
    private String result;
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
    @Column(name = "body", nullable = false, insertable = true, updatable = true, length = 2147483647)
    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Basic
    @Column(name = "result", nullable = false, insertable = true, updatable = true, length = 2147483647)
    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Test test = (Test) o;

        if (id != test.id) return false;
        if (body != null ? !body.equals(test.body) : test.body != null) return false;
        if (result != null ? !result.equals(test.result) : test.result != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result1 = id;
        result1 = 31 * result1 + (body != null ? body.hashCode() : 0);
        result1 = 31 * result1 + (result != null ? result.hashCode() : 0);
        return result1;
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
