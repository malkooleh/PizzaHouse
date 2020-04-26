package ua.pizzeria.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ua.pizzeria.controller.dto.LoginForm;
import ua.pizzeria.model.Category;
import ua.pizzeria.model.User;
import ua.pizzeria.services.CategoryService;
import ua.pizzeria.services.UserService;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j

@Controller
@RequestMapping("/")
public class AppController {

    private static final String ATTRIBUTE_MODEL_TO_VIEW = "categoryList";
    private static final String PAGE_ERROR = "redirect:/index";
    private static final String LOGIN_VIEW = "login";
    private static final String LOGOUT_VIEW = "logout";

    private final CategoryService categoryService;
    private final UserService userService;

    public AppController(CategoryService categoryService, UserService userService) {
        this.categoryService = categoryService;
        this.userService = userService;
    }

    @GetMapping(value = {"", "index"})
    public String index(Model model) {
        model.addAttribute("loginForm", new LoginForm());
        return LOGIN_VIEW;
    }

    @PostMapping(value = "login")
    public String signIn(@Valid @ModelAttribute("loginForm") LoginForm form, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            User profile = userService.getByLogin(form.getLogin());

            if (profile == null || !profile.getPassword().equals(form.getPassword())) {
                return LOGIN_VIEW;
            }
        } else {
            return LOGIN_VIEW;
        }

        return "home";
    }

    @GetMapping("logout")
    public String showSignUp(Model model) {
        model.addAttribute("form", new LoginForm());
        return LOGOUT_VIEW;
    }

    @PostMapping(value = "logout")
    public String signUp(@Valid @ModelAttribute("loginForm") LoginForm form,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return LOGIN_VIEW;
        }

        User newUser;
        User profile;
        profile = userService.getByLogin(form.getLogin());

        if (profile == null) {
            newUser = new User();
            newUser.setLogin(form.getLogin());
            newUser.setPassword(form.getPassword());
            newUser.setEmail(form.getEmail());
            userService.add(newUser);
        } else {
            return LOGIN_VIEW;
        }

        return "items";
    }

    @GetMapping(value = "catalog")
    public String viewCategories(Model model) {
        List<Category> categoryList = categoryService.getAll();
        model.addAttribute(ATTRIBUTE_MODEL_TO_VIEW, categoryList);

        return "catalog";
    }

    @PostMapping(value = "/catalog/delete/{id}")
    public String deleteCategory(@PathVariable Integer id) {
        categoryService.delete(categoryService.getById(id));
        return "redirect:/catalog";
/*        return this.productRepository.findOneById(productId)
                .map(product -> new ModelAndView("catalog/products/product",
                        Map.of("product", product), HttpStatus.OK))
                .orElseGet(() -> new ModelAndView("errors/404",
                        Map.of("error", "Couldn't find MyAccessDeniedHandler product"), HttpStatus.NOT_FOUND));*/
    }

    @GetMapping(value = {"/user"}, produces = "application/json")
    public Map<String, Object> user(OAuth2Authentication user) {
        Map<String, Object> userInfo = new HashMap<>();
        userInfo.put(
                "user",
                user.getUserAuthentication()
                        .getPrincipal());
        userInfo.put(
                "authorities",
                AuthorityUtils.authorityListToSet(
                        user.getUserAuthentication()
                                .getAuthorities()));

        log.info("User : {}\n Authorities : {}",userInfo.get("user"), userInfo.get("authorities"));
        return userInfo;
    }
}
