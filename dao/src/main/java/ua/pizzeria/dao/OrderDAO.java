package ua.pizzeria.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.pizzeria.dto.CartItem;
import ua.pizzeria.model.Order;
import ua.pizzeria.model.User;

import java.util.List;

@Repository
public interface OrderDAO extends CrudRepository<Order, Integer> {

//    Order createOrder(User user, List<CartItem> cartItems);

}
