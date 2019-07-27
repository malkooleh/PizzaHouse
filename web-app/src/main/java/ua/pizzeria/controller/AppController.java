package ua.pizzeria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.pizzeria.model.Category;
import ua.pizzeria.model.User;
import ua.pizzeria.services.CategoryService;
import ua.pizzeria.services.UserService;

import java.util.List;

@RestController
public class AppController {

    private static final String ATTRIBUTE_MODEL_TO_VIEW = "categoryList";
    private static final String PAGE_ERROR = "redirect:/index";

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView home(){
        return new ModelAndView("index", "user", new User());
    }

    @RequestMapping(value = "signin", method = RequestMethod.POST)
    public String signIn(@ModelAttribute("user") User user) {
        User profile;
        profile = userService.getByLogin(user.getLogin());
        if (profile == null) {
            return "index";
        } else if (!profile.getPassword().equals(user.getPassword())) {
            return "index";
        }
        return "home";
    }

    @RequestMapping(value = "signup", method = RequestMethod.POST)
    public String signUp(@PathVariable String login,@PathVariable String password){
        User newUser;
        User profile;
        profile = userService.getByLogin(login);
        if (profile == null) {
            newUser = new User();
            newUser.setLogin(login);
            newUser.setPassword(password);
            userService.add(newUser);
        } else {
            return "index";
        }
        return "items";
    }

    @RequestMapping(value = "catalog", method = RequestMethod.GET)
    public String viewCategories(Model model) {
        List<Category> categoryList = categoryService.getAll();
        model.addAttribute(ATTRIBUTE_MODEL_TO_VIEW, categoryList);

        return "catalog";
    }

    @RequestMapping(value="/catalog/delete/{id}", method=RequestMethod.POST)
    public String deleteCategory(@PathVariable Integer id) {
        categoryService.delete(categoryService.getById(id));
        return "redirect:/catalog";
    }
}
