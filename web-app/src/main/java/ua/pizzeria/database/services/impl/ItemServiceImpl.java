package ua.pizzeria.database.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.pizzeria.database.dao.ItemDAO;
import ua.pizzeria.database.model.Item;
import ua.pizzeria.database.services.ItemService;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ItemServiceImpl.class);

    private final ItemDAO itemDAO;

    public ItemServiceImpl(@Qualifier("itemDAO") ItemDAO itemDAO) {
        this.itemDAO = itemDAO;
    }

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

        LOGGER.debug("List<ItemList> getAll() from ItemServiceImpl");

        return (List<Item>) itemDAO.findAll();
    }

    @Override
    public void add(Item entity) {
        itemDAO.save(entity);
    }

    @Override
    public Item update(Item entity) {
        return itemDAO.save(entity);
    }

    @Override
    public Optional<Item> getById(Integer id) {
        Optional<Item> optionalItem = itemDAO.findById(id);
        return Optional.of(optionalItem.orElseThrow(() -> new RuntimeException("Couldn't find a ItemList with id: " + id)));
    }

    @Override
    public void delete(Item entity) {
        itemDAO.delete(entity);
    }

    @Override
    public void deleteById(Integer id) {
        itemDAO.deleteById(id);
    }
}
