package ua.pizzeria.dao.impl;

import org.springframework.stereotype.Repository;
import ua.pizzeria.dao.ItemDAO;
import ua.pizzeria.model.Item;

import java.util.List;

@Repository("itemDAO")
public class ItemDAOImpl extends AbstractDAOImpl<Item> implements ItemDAO {

    @Override
    public Item getByName(String name) {
        return (Item) getCurrentSession().createQuery("from Item i where i.name = :name")
                .setParameter("name", name).getSingleResult();
    }

    @Override
    public List<Item> getByCategoryID(Integer categoryId) {
        return getCurrentSession().createQuery("from Item i where i.category.id = :categoryId")
                .setParameter("categoryId", categoryId).getResultList();
    }
}
