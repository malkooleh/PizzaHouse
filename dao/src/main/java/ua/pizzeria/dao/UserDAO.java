package ua.pizzeria.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.pizzeria.model.User;

@Repository
public interface UserDAO extends CrudRepository<User, Integer> {

    User findByLogin(String login);

    @Override
    void deleteById(Integer integer);
}
