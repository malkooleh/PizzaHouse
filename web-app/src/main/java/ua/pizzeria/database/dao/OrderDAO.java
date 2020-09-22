package ua.pizzeria.database.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.pizzeria.database.model.Order;

@Repository
public interface OrderDAO extends CrudRepository<Order, Integer> {

//    Order createOrder(User user, List<CartItem> cartItems);

}
