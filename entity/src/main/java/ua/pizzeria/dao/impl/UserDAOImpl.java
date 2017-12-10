package ua.pizzeria.dao.impl;

import org.springframework.stereotype.Repository;
import ua.pizzeria.dao.UserDAO;
import ua.pizzeria.model.User;

@Repository("userDAO")
public class UserDAOImpl extends AbstractDAOImpl<User> implements UserDAO {

    @Override
    public User getByLogin(String login) {
        return (User) getCurrentSession().createQuery("from User u where u.login = ?")
                .setParameter(0, login).getSingleResult();
    }
}
