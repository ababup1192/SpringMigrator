package org.ababup1192.member.after;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class NewMember {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(length = 50, nullable = false)
    private String name;

    @Column
    private Double weight;

    public NewMember() {
    }

    public NewMember(String name, Double weight) {
        this.name = name;
        this.weight = weight;
    }

    public NewMember(Integer id, String name, Double weight) {
        this.id = id;
        this.name = name;
        this.weight = weight;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NewMember newMember = (NewMember) o;

        if (id != null ? !id.equals(newMember.id) : newMember.id != null) return false;
        if (name != null ? !name.equals(newMember.name) : newMember.name != null) return false;
        return weight != null ? weight.equals(newMember.weight) : newMember.weight == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (weight != null ? weight.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "NewMember{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }
}

