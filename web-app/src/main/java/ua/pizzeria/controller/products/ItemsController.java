package ua.pizzeria.controller.products;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import ua.pizzeria.model.Item;
import ua.pizzeria.services.ItemService;

@Controller
public class ItemsController {

    private static final String ITEMS_VIEW = "items";
    private final ItemService itemService;

    public ItemsController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping(value = "items")
    public String viewItems(Model model) {

        model.addAttribute("item", new Item());
        model.addAttribute("itemList", itemService.getAll());

        return ITEMS_VIEW;
    }

    @GetMapping(value = "items/{id}")
    public String viewItems(@PathVariable Integer id, Model model) {

        model.addAttribute("item", new Item());
        model.addAttribute("itemList", itemService.getByCategoryID(id));

        return ITEMS_VIEW;
    }

    @PostMapping(value = "items/add", produces = "text/html;charset=UTF-8")
    public String addItem(@ModelAttribute("item") Item item) {

        if (StringUtils.isEmpty(item)) {
            return "/catalog";
        } else if (!StringUtils.isEmpty(item.getName())) {
            this.itemService.add(item);
        } else {
            this.itemService.update(item);
        }
        return ITEMS_VIEW;
    }

    @DeleteMapping("/remove/{id}")
    public String removeBook(@PathVariable("id") Integer id) {
        this.itemService.delete(itemService.getById(id));

        return "redirect:/items";
    }

    @PutMapping("edit/{id}")
    public String editBook(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("item", this.itemService.getById(id));
        model.addAttribute("listItems", this.itemService.getAll());

        return ITEMS_VIEW;
    }

    @GetMapping("itemdata/{id}")
    public String bookData(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("item", this.itemService.getById(id));

        return "itemdata";
    }
}
