package ua.pizzeria.services.serviceImpl;

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
        return itemDAO.getByCategoryID(categoryId);
    }

    @Override
    public List<Item> getAll() {

        LOGGER.debug("List<Item> getAll() from ItemServiceImpl");

        return itemDAO.getAll();
    }

    @Override
    public void add(Item entity) {
        itemDAO.save(entity);
    }

    @Override
    public void update(Item entity) {
        itemDAO.update(entity);
    }

    @Override
    public Item getById(Integer id) {
        return itemDAO.getById(id);
    }

    @Override
    public void delete(Item entity) {
        itemDAO.delete(entity);
    }
}
