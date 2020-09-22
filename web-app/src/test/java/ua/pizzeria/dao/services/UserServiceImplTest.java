package ua.pizzeria.dao.services;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import ua.pizzeria.dao.config.BaseTestConfig;
import ua.pizzeria.database.model.User;
import ua.pizzeria.database.services.UserService;

import java.util.List;

public class UserServiceImplTest extends BaseTestConfig {

    @Autowired
    private UserService userService;

    @Test
    public void getUserList() {
        List<User> userList = userService.getUserList();

        if (CollectionUtils.isEmpty(userList)) Assert.fail("Not found users in db");
    }

    @Test
    public void add() {
    }

    @Test
    public void getByLogin() {
    }

    @Test
    public void create() {
    }

    @Test
    public void updateUser() {
    }

    @Test
    public void deleteUser() {
    }

    @Test
    public void findById() {
    }
}