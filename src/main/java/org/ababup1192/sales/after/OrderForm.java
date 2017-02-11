package org.ababup1192.sales.after;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class OrderForm {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id")
    private Client client;
    private Date date;

    @OneToMany(mappedBy = "orderForm")
    private List<Sales> salesList;

    public OrderForm(){}

    public OrderForm(Client client, Date date) {
        this.client = client;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Sales> getSalesList() {
        return salesList;
    }

    public void setSalesList(List<Sales> salesList) {
        this.salesList = salesList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderForm orderForm = (OrderForm) o;

        if (client != null ? !client.equals(orderForm.client) : orderForm.client != null) return false;
        return date != null ? date.getTime() == orderForm.date.getTime() : orderForm.date == null;

    }

    @Override
    public int hashCode() {
        int result = client != null ? client.hashCode() : 0;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "OrderForm{" +
                "id=" + id +
                ", client=" + client +
                ", date=" + date +
                '}';
    }
}
