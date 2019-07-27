package ua.pizzeria.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.pizzeria.model.OrderLine;

@Repository
public interface OrderLineDAO extends CrudRepository<OrderLine, Integer> {

}
