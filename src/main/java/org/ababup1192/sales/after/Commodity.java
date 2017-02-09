package org.ababup1192.sales.after;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

public class Commodity {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private Integer unitPrice;
    @OneToMany(mappedBy = "commodity")
    private List<Sales> salesList;

    public Commodity() {
    }

    public Commodity(String name, Integer unitPrice) {
        this.name = name;
        this.unitPrice = unitPrice;
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

    public Integer getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Integer unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Commodity commodity = (Commodity) o;

        if (id != null ? !id.equals(commodity.id) : commodity.id != null) return false;
        if (name != null ? !name.equals(commodity.name) : commodity.name != null) return false;
        return unitPrice != null ? unitPrice.equals(commodity.unitPrice) : commodity.unitPrice == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (unitPrice != null ? unitPrice.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Commodity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", unitPrice=" + unitPrice +
                '}';
    }
}
