package org.ababup1192.member.after;

import org.ababup1192.util.DateUtil;

import javax.persistence.*;
import java.util.Date;

@Entity
public class NewMember {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(length = 50, nullable = false)
    private String name;

    @Column
    private Double weight;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date createTime;

    public NewMember() {
    }

    public NewMember(String name, Double weight, Date createTime) {
        this.name = name;
        this.weight = weight;
        this.createTime = createTime;
    }

    public NewMember(Integer id,String name, Double weight, Date createTime) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.createTime = createTime;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NewMember newMember = (NewMember) o;

        if (id != null ? !id.equals(newMember.id) : newMember.id != null) return false;
        if (name != null ? !name.equals(newMember.name) : newMember.name != null) return false;
        if (weight != null ? !weight.equals(newMember.weight) : newMember.weight != null) return false;
        return createTime != null ?  DateUtil.isEqual(createTime, newMember.createTime) : newMember.createTime == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (weight != null ? weight.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "NewMember{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", createTime=" + createTime +
                '}';
    }
}

