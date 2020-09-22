package ua.pizzeria.controller;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import ua.pizzeria.database.model.Category;
import ua.pizzeria.database.services.CategoryService;

import java.util.Collection;
import java.util.Objects;

@RestController
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @GetMapping(value = "/categories")
    public Collection<Category> getCategories() {
        return categoryService.getAll();
    }

    @GetMapping(value = "/category/{id}")
    public Category getCategory(@PathVariable Integer id) {
        return categoryService.getById(id);
    }

    @PostMapping(value = "/category/add")
    public void addCategory(Category category) {

        if (Objects.nonNull(category) && !StringUtils.isEmpty(category.getName())) {

            Category byName = categoryService.getCategoryByName(category.getName());

            if (Objects.nonNull(byName)) {
                categoryService.update(category);
            }
        } else {
            categoryService.add(category);
        }
    }

    @DeleteMapping("/category/remove/{id}")
    public void removeCategory(@PathVariable("id") Integer id) {
        categoryService.deleteById(id);
    }

    @PutMapping("/category/edit/{id}")
    public void editCategory(@PathVariable("id") Integer id) {
        categoryService.update(categoryService.getById(id));
    }
}
