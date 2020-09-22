package ua.pizzeria.database.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ua.pizzeria.database.model.Item;

import java.util.List;

@Repository
public interface ItemDAO extends PagingAndSortingRepository<Item, Integer> {

    Item getByName(String name);

    List<Item> findAllByCategoryId(Integer categoryId);

}
