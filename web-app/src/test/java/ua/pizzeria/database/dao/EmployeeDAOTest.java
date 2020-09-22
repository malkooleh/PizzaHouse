package ua.pizzeria.database.dao;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import ua.pizzeria.dao.config.BaseTestConfig;
import ua.pizzeria.database.model.Employee;

import java.util.List;
import java.util.Objects;

public class EmployeeDAOTest extends BaseTestConfig {

    @Autowired
    EmployeeDAO employeeDAO;

    @Test
    public void findByFirstName() {
        Employee employee = employeeDAO.findByFirstName("Devid");

        if (Objects.isNull(employee)) Assert.fail("Not found employees in db");
    }

    @Test
    public void findAll() {
        List<Employee> employee = employeeDAO.findAll();

        if (CollectionUtils.isEmpty(employee)) Assert.fail("Not found employees in db");
    }
}
