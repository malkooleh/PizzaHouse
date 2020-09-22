package ua.pizzeria.database.services;

import ua.pizzeria.database.model.Employee;

import java.util.List;

public interface EmployeeService {

    Employee findByName(String name);

    List<Employee> getAll();

    Employee add(Employee entity);

    void update(Employee entity);

    Employee getById(Long id);

    void delete(Employee entity);

    void deleteById(Long id);
}
