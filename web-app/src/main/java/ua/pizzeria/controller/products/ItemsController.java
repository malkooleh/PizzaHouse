package ua.pizzeria.controller.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import ua.pizzeria.model.Item;
import ua.pizzeria.services.ItemService;

@Controller
public class ItemsController {

    @Autowired
    @Qualifier("itemServiceImpl")
    private ItemService itemService;

    @RequestMapping(value = "items", method = RequestMethod.GET)
    public String viewItems(Model model) {

        model.addAttribute("item", new Item());
        model.addAttribute("itemList", itemService.getAll());

        return "items";
    }

    @RequestMapping(value = "items/{id}", method = RequestMethod.GET)
    public String viewItems(@PathVariable Integer id, Model model) {

        model.addAttribute("item", new Item());
        model.addAttribute("itemList", itemService.getByCategoryID(id));

        return "items";
    }

    @RequestMapping(value = "items/add", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public String addItem(@ModelAttribute("item") Item item) {

        if (StringUtils.isEmpty(item)) {
            return "/catalog";
        } else if (!StringUtils.isEmpty(item.getName())) {
            this.itemService.add(item);
        } else {
            this.itemService.update(item);
        }
        return "/items";
    }

    @RequestMapping("/remove/{id}")
    public String removeBook(@PathVariable("id") Integer id) {
        this.itemService.delete(itemService.getById(id));

        return "redirect:/items";
    }

    @RequestMapping("edit/{id}")
    public String editBook(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("item", this.itemService.getById(id));
        model.addAttribute("listItems", this.itemService.getAll());

        return "items";
    }

    @RequestMapping("itemdata/{id}")
    public String bookData(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("item", this.itemService.getById(id));

        return "itemdata";
    }
}
