package ua.pizzeria.database.services;

import ua.pizzeria.database.model.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getAll();

    void add(Category category);

    void update(Category category);

    Category getById(Integer id);

    void delete(Category byId);

    void deleteById(Integer id);

    Category getCategoryByName(String categoryName);
}
