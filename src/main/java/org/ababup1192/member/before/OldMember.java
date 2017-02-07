package org.ababup1192.member.before;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class OldMember {
    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private Integer weight;

    public OldMember(){}

    public OldMember(String name, Integer weight) {
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

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OldMember oldMember = (OldMember) o;

        if (id != null ? !id.equals(oldMember.id) : oldMember.id != null) return false;
        if (name != null ? !name.equals(oldMember.name) : oldMember.name != null) return false;
        return weight != null ? weight.equals(oldMember.weight) : oldMember.weight == null;

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
        return "OldMember{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }
}
