package ua.pizzeria.services;

import ua.pizzeria.model.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getAll();

    void add(Category category);

    void update(Category category);

    Category getById(Integer id);

    void delete(Category byId);

    Category getCategoryByName(String categoryName);
}
