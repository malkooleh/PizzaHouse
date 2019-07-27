package ua.pizzeria.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.pizzeria.model.Category;

@Repository
public interface CategoryDAO extends CrudRepository<Category, Integer> {

    Category findCategoryByName(String categoryName);

}
