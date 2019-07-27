package ua.pizzeria.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.pizzeria.dao.ItemDAO;
import ua.pizzeria.model.Item;
import ua.pizzeria.services.ItemService;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ItemServiceImpl.class);

    @Autowired
    @Qualifier("itemDAO")
    ItemDAO itemDAO;

    @Override
    public Item getByName(String name) {
        return itemDAO.getByName(name);
    }

    @Override
    public List<Item> getByCategoryID(Integer categoryId) {
        return itemDAO.findAllByCategoryId(categoryId);
    }

    @Override
    public List<Item> getAll() {

        LOGGER.debug("List<Item> getAll() from ItemServiceImpl");

        return (List<Item>) itemDAO.findAll();
    }

    @Override
    public void add(Item entity) {
        itemDAO.save(entity);
    }

    @Override
    public void update(Item entity) {
        itemDAO.save(entity);
    }

    @Override
    public Item getById(Integer id) {
        Optional<Item> optionalItem = itemDAO.findById(id);
        return optionalItem.orElseThrow(() -> new RuntimeException("Couldn't find a Item with id: " + id));
    }

    @Override
    public void delete(Item entity) {
        itemDAO.delete(entity);
    }
}
