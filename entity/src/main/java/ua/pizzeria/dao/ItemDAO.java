package ua.pizzeria.dao;

import ua.pizzeria.model.Item;

import java.util.List;

public interface ItemDAO extends BasicDAO<Item> {

    Item getByName(String name) ;

    List<Item> getByCategoryID(Integer categoryId);

}
