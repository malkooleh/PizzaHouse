package ua.pizzeria.service;

import ua.pizzeria.entity.User;

import java.util.List;

public interface UserService {

    List<User> getUserList();

    void add(User user);

    User getByLogin(String login);

    User create(User user);

    void updateUser(User user);

    void deleteUser(Long id);

    User findById(Long id);
}
