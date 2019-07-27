package ua.pizzeria.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.pizzeria.model.Item;

import java.util.List;

@Repository
public interface ItemDAO extends CrudRepository<Item, Integer> {

    Item getByName(String name);

    List<Item> findAllByCategoryId(Integer categoryId);

}
