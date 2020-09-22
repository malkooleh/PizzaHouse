package ua.pizzeria.database.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.pizzeria.database.model.Roles;

@Repository
public interface RoleDAO extends CrudRepository<Roles, Integer> {
}
