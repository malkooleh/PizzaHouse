package ua.pizzeria.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ua.pizzeria.model.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class ItemsController {

    private List<Item> items;

    public ItemsController() {
        this.items = new ArrayList<>();

        Item item = new Item();
        item.setId(1);
        item.setName("4Cheeses");
        item.setCategory("Pizza");

        items.add(item);
    }

    @GetMapping("/item")
    @ResponseBody
    public Optional<Item> getEmployee(@RequestParam String name) {
        return items.stream().filter(x -> x.getName().equals(name)).findAny();
    }

    @PostMapping(value = "/item", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void postMessage(@RequestBody Item item) {
        items.add(item);
    }

}
