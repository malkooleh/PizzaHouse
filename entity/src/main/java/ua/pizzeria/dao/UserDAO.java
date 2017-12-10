package ua.pizzeria.dao;

import ua.pizzeria.model.User;

public interface UserDAO extends BasicDAO<User> {

    User getByLogin(String login);

}
