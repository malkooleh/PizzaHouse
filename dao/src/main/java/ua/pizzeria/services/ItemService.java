package ua.pizzeria.services;

import ua.pizzeria.model.Item;

import java.util.List;

public interface ItemService {

    Item getByName(String name);

    List<Item> getByCategoryID(Integer categoryId);

    List<Item> getAll();

    void add(Item entity);

    void update(Item entity);

    Item getById(Integer id);

    void delete(Item entity);
}
