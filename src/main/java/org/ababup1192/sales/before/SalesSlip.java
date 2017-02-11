package org.ababup1192.sales.before;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity
public class SalesSlip implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;
    private String clientName;
    private String address;
    private String commodityName;
    private Integer unitPrice;
    private Integer quantity;
    private Integer total;
    private Date date;

    public SalesSlip() {
    }

    public SalesSlip(String clientName, String address, String commodityName,
                     Integer unitPrice, Integer quantity,
                     Integer total, Date date) {
        this.clientName = clientName;
        this.address = address;
        this.commodityName = commodityName;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.total = total;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public Integer getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Integer unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SalesSlip salesSlip = (SalesSlip) o;

        if (id != null ? !id.equals(salesSlip.id) : salesSlip.id != null) return false;
        if (clientName != null ? !clientName.equals(salesSlip.clientName) : salesSlip.clientName != null) return false;
        if (address != null ? !address.equals(salesSlip.address) : salesSlip.address != null) return false;
        if (commodityName != null ? !commodityName.equals(salesSlip.commodityName) : salesSlip.commodityName != null)
            return false;
        if (unitPrice != null ? !unitPrice.equals(salesSlip.unitPrice) : salesSlip.unitPrice != null) return false;
        if (quantity != null ? !quantity.equals(salesSlip.quantity) : salesSlip.quantity != null) return false;
        if (total != null ? !total.equals(salesSlip.total) : salesSlip.total != null) return false;
        return date != null ? date.equals(salesSlip.date) : salesSlip.date == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (clientName != null ? clientName.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (commodityName != null ? commodityName.hashCode() : 0);
        result = 31 * result + (unitPrice != null ? unitPrice.hashCode() : 0);
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        result = 31 * result + (total != null ? total.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "SalesSlip{" +
                "id=" + id +
                ", clientName='" + clientName + '\'' +
                ", address='" + address + '\'' +
                ", commodityName=" + commodityName +
                ", unitPrice=" + unitPrice +
                ", quantity=" + quantity +
                ", total=" + total +
                ", date=" + date +
                '}';
    }
}
