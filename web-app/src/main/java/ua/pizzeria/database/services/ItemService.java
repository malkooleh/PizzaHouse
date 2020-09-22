package ua.pizzeria.database.services;

import ua.pizzeria.database.model.Item;

import java.util.List;
import java.util.Optional;

public interface ItemService {

    Item getByName(String name);

    List<Item> getByCategoryID(Integer categoryId);

    List<Item> getAll();

    void add(Item entity);

    Item update(Item entity);

    Optional<Item> getById(Integer id);

    void delete(Item entity);

    void deleteById(Integer id);
}
