package ua.pizzeria.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ua.pizzeria.entity.User;
import ua.pizzeria.service.UserService;

@Slf4j
@AllArgsConstructor

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @PostMapping("/")
    public User saveUser(@RequestBody User user) {
        log.info("Inside saveUser of UserController");
        return userService.create(user);
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable("id") Long userId) {
        log.info("Inside getUserWithDepartment of UserController");
        return userService.findById(userId);
    }

}
