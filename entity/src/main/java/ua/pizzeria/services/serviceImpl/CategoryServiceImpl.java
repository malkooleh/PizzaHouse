package ua.pizzeria.services.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.pizzeria.dao.CategoryDAO;
import ua.pizzeria.model.Category;
import ua.pizzeria.services.CategoryService;

import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDAO categoryDAO;

    @Override
    public List<Category> getAll() {
        return categoryDAO.getAll();
    }

    @Override
    public void add(Category category) {
        categoryDAO.add(category);
    }

    @Override
    public void update(Category category) {
        categoryDAO.update(category);
    }

    @Override
    public Category getById(Integer id) {
        return categoryDAO.getById(id);
    }

    @Override
    public void delete(Category byId) {
        categoryDAO.delete(byId);
    }

    @Override
    public Category getCategoryByName(String categoryName) {
        return categoryDAO.getCategoryByName(categoryName);
    }
}
