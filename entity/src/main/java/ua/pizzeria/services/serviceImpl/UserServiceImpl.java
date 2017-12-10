package ua.pizzeria.services.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.pizzeria.dao.UserDAO;
import ua.pizzeria.model.User;
import ua.pizzeria.services.UserService;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDAO userDAO;

    @Override
    public List<User> getUserList() {
        return userDAO.getAll();
    }

    @Override
    public void add(User user) {
        userDAO.add(user);
    }

    @Override
    public User getByLogin(String login) {
        return userDAO.getByLogin(login);
    }

    @Override
    public void create(User user) {
        userDAO.add(user);
    }

    @Override
    public void updateUser(User user) {
        userDAO.update(user);
    }

    @Override
    public void deleteUser(Integer id) {
        userDAO.delete(userDAO.getById(id));
    }

    @Override
    public User findById(Integer id) {
        return userDAO.getById(id);
    }
}
