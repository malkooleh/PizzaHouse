package ua.pizzeria.dao;

import ua.pizzeria.model.Category;

public interface CategoryDAO extends BasicDAO<Category> {

    Category getCategoryByName(String categoryName);

}
