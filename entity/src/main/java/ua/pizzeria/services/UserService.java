package ua.pizzeria.services;

import ua.pizzeria.model.User;

import java.util.List;

public interface UserService {

    List<User> getUserList();

    void add(User user);

    User getByLogin(String login);

    void create(User user);

    void updateUser(User user);

    void deleteUser(Integer id);

    User findById(Integer id);
}
