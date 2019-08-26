package ua.pizzeria.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "orderline")
public class OrderLine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    private int quantity;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    public BigDecimal getTotalPrice() {
        return item.getUnitPrice().multiply(BigDecimal.valueOf(quantity));
    }

    public int getId() {
        return id;
    }

    public void setId(int order_id) {
        this.id = order_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "OrderLine{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", items=" + item +
                '}';
    }
}
