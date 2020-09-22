package ua.pizzeria.database.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.pizzeria.database.model.Category;

@Repository
public interface CategoryDAO extends CrudRepository<Category, Integer> {

    Category findCategoryByName(String categoryName);

}
