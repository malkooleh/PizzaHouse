package ua.pizzeria.dao;

import ua.pizzeria.dto.CartItem;
import ua.pizzeria.model.Order;
import ua.pizzeria.model.User;

import java.util.List;

public interface OrderDAO extends BasicDAO<Order>{

    Order createOrder(User user, List<CartItem> cartItems);

}
