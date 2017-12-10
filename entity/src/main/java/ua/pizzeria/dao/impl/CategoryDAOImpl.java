package ua.pizzeria.dao.impl;

import org.springframework.stereotype.Repository;
import ua.pizzeria.dao.CategoryDAO;
import ua.pizzeria.model.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl extends AbstractDAOImpl<Category> implements CategoryDAO {

    @Override
    public Category getCategoryByName(String categoryName) {
        return (Category) getCurrentSession().createQuery("from Category c WHERE c.name = :name")
                .setParameter("name", categoryName).getSingleResult();
    }
}
