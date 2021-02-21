package ua.pizzeria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.pizzeria.entity.User;

@Repository
public interface UserRepository  extends JpaRepository<User,Long> {

    User findByLogin(String login);
}
