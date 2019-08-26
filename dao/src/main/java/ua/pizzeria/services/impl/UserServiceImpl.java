package ua.pizzeria.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.pizzeria.dao.UserDAO;
import ua.pizzeria.model.User;
import ua.pizzeria.services.UserService;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;

    @Override
    public List<User> getUserList() {
        return (List<User>) userDAO.findAll();
    }

    @Override
    public void add(User user) {
        userDAO.save(user);
    }

    @Override
    public User getByLogin(String login) {
        return userDAO.findByLogin(login);
    }

    @Override
    public void create(User user) {
        userDAO.save(user);
    }

    @Override
    public void updateUser(User user) {
        userDAO.save(user);
    }

    @Override
    public void deleteUser(Integer id) {
        userDAO.deleteById(id);
    }

    @Override
    public User findById(Integer id) {
        Optional<User> optionalUser = userDAO.findById(id);
        return optionalUser.orElseThrow(() -> new RuntimeException("Couldn't find a Category with id: " + id));
    }
}
