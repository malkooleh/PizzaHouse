package ua.pizzeria.database.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.pizzeria.database.dao.EmployeeDAO;
import ua.pizzeria.database.model.Employee;
import ua.pizzeria.database.services.EmployeeService;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDAO employeeDAO;

    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public Employee findByName(String name) {
        return employeeDAO.findByFirstName(name);
    }

    @Override
    public List<Employee> getAll() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee add(Employee entity) {
        employeeDAO.save(entity);
        return entity;
    }

    @Override
    public void update(Employee entity) {
        employeeDAO.save(entity);
    }

    @Override
    public Employee getById(Long id) {
        Optional<Employee> optionalItem = employeeDAO.findById(id);
        return optionalItem.orElseThrow(() -> new RuntimeException("Couldn't find a Employee with id: " + id));
    }

    @Override
    public void delete(Employee entity) {
        employeeDAO.delete(entity);
    }

    @Override
    public void deleteById(Long id) {
        employeeDAO.deleteById(id);
    }
}
