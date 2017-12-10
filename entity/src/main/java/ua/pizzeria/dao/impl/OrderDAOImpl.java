package ua.pizzeria.dao.impl;

import org.springframework.stereotype.Repository;
import ua.pizzeria.dao.OrderDAO;
import ua.pizzeria.dto.CartItem;
import ua.pizzeria.model.Order;
import ua.pizzeria.model.OrderLine;
import ua.pizzeria.model.User;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository("orderDAO")
public class OrderDAOImpl extends AbstractDAOImpl<Order> implements OrderDAO {

    @Override
    public Order createOrder(User user, List<CartItem> cartItems) {
        Order order = new Order();
        order.setUser(user);
        Set<OrderLine> orderLines = new HashSet<>();

        for (CartItem cartItem : cartItems) {
            OrderLine orderLine = new OrderLine();
            orderLine.setQuantity(cartItem.getQuantity());
            orderLine.setItem(cartItem.getItem());
            orderLines.add(orderLine);
        }
        order.setOrderLines(orderLines);
        getCurrentSession().save(order);

        return order;
    }
}
