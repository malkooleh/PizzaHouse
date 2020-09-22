package ua.pizzeria.database.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.pizzeria.database.dao.CategoryDAO;
import ua.pizzeria.database.model.Category;
import ua.pizzeria.database.services.CategoryService;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    private final CategoryDAO categoryDAO;

    public CategoryServiceImpl(CategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }

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
        return optionalCategory.orElseThrow(() -> new RuntimeException("Couldn't find a CategoryList with id: " + id));
    }

    @Override
    public void delete(Category byId) {
        categoryDAO.delete(byId);
    }

    @Override
    public void deleteById(Integer id) {
        categoryDAO.deleteById(id);
    }

    @Override
    public Category getCategoryByName(String categoryName) {
        return categoryDAO.findCategoryByName(categoryName);
    }
}
