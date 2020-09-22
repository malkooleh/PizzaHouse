package ua.pizzeria.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.pizzeria.database.model.Employee;

@Repository
public interface EmployeeDAO extends JpaRepository<Employee, Long> {

    Employee findByFirstName(String name);
}
