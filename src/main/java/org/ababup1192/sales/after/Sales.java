package org.ababup1192.sales.after;

import javax.persistence.*;

@Entity
@NamedEntityGraph(
        name = "sales.graph",
        attributeNodes = {
                @NamedAttributeNode("quantity"),
                @NamedAttributeNode(value = "orderForm", subgraph = "orderForm"),
                @NamedAttributeNode(value = "commodity", subgraph = "commodity")
        }, subgraphs = {
        @NamedSubgraph(name = "orderForm", attributeNodes = {
                @NamedAttributeNode(value = "client", subgraph = "client")
        }),
        @NamedSubgraph(name = "client", attributeNodes = {
                @NamedAttributeNode(value = "name"),
                @NamedAttributeNode(value = "address")
        }),
        @NamedSubgraph(name = "commodity", attributeNodes = {
                @NamedAttributeNode("name"),
                @NamedAttributeNode("unitPrice")
        })
}
)
public class Sales {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_form_id")
    public OrderForm orderForm;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "commodity_id")
    private Commodity commodity;
    private Integer quantity;

    public Sales() {
    }

    public Sales(OrderForm orderForm, Commodity commodity, Integer quantity) {
        this.orderForm = orderForm;
        this.commodity = commodity;
        this.quantity = quantity;
    }

    public Sales(Integer id, OrderForm orderForm, Commodity commodity, Integer quantity) {
        this.id = id;
        this.orderForm = orderForm;
        this.commodity = commodity;
        this.quantity = quantity;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sales sales = (Sales) o;

        if (id != null ? !id.equals(sales.id) : sales.id != null) return false;
        if (orderForm != null ? !orderForm.equals(sales.orderForm) : sales.orderForm != null) return false;
        if (commodity != null ? !commodity.equals(sales.commodity) : sales.commodity != null) return false;
        return quantity != null ? quantity.equals(sales.quantity) : sales.quantity == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (orderForm != null ? orderForm.hashCode() : 0);
        result = 31 * result + (commodity != null ? commodity.hashCode() : 0);
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Sales{" +
                "id=" + id +
                ", orderForm=" + orderForm +
                ", commodity=" + commodity +
                ", quantity=" + quantity +
                '}';
    }
}
