package ua.pizzeria.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.pizzeria.dao.CategoryDAO;
import ua.pizzeria.model.Category;
import ua.pizzeria.services.CategoryService;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDAO categoryDAO;

    @Override
    public List<Category> getAll() {
        return (List<Category>) categoryDAO.findAll();
    }

    @Override
    public void add(Category category) {
        categoryDAO.save(category);
    }

    @Override
    public void update(Category category) {
        categoryDAO.save(category);
    }

    @Override
    public Category getById(Integer id) {
        Optional<Category> optionalCategory = categoryDAO.findById(id);
        return optionalCategory.orElseThrow(() -> new RuntimeException("Couldn't find a Category with id: " + id));
    }

    @Override
    public void delete(Category byId) {
        categoryDAO.delete(byId);
    }

    @Override
    public Category getCategoryByName(String categoryName) {
        return categoryDAO.findCategoryByName(categoryName);
    }
}
