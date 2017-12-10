package ua.pizzeria.dao.impl;

import org.springframework.stereotype.Repository;
import ua.pizzeria.dao.OrderLineDAO;
import ua.pizzeria.model.OrderLine;

@Repository("orderLineDAO")
public class OrderLineDAOImpl extends AbstractDAOImpl<OrderLine> implements OrderLineDAO {

}
