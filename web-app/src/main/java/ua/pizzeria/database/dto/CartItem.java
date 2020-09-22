package ua.pizzeria.database.dto;

import ua.pizzeria.database.model.Item;

import java.math.BigDecimal;

public class CartItem {

    private Item item;

    private Integer quantity;

    public CartItem(Item item, Integer quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public BigDecimal getSubTotal() {
        return item.getUnitPrice().multiply(BigDecimal.valueOf(quantity));
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("CartItem");
        sb.append("{items='").append(item).append('\'');
        sb.append(", quantity='").append(quantity).append('\'');
        sb.append('}');
        return sb.toString();
    }

}
