package ua.pizzeria.controller.products;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.pizzeria.database.model.Item;
import ua.pizzeria.database.services.ItemService;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping
public class ItemsController {

    private final ItemService itemService;

    public ItemsController(ItemService itemService) {
        this.itemService = itemService;
    }

    //    @PreAuthorize("#oauth2.hasScope('webclient') and #oauth2.hasScope('read')")
    @GetMapping(value = "/items")
    public Collection<Item> getItems() {
        return itemService.getAll();
    }

    //    @PreAuthorize("#oauth2.hasScope('webclient') and #oauth2.hasScope('read')")
    @GetMapping(value = "/items/{id}")
    public ResponseEntity<Item> getItem(@PathVariable Integer id) {
        Optional<Item> item = itemService.getById(id);
        return item.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping(value = "/items/byCategory/{categoryId}")
    public ResponseEntity<?> getItemsByCategory(@PathVariable Integer categoryId) {
        List<Item> itemList = itemService.getByCategoryID(categoryId);
        return ResponseEntity.ok(itemList);
    }

    //    @PreAuthorize("#oauth2.hasScope('webclient') and #oauth2.hasScope('write') and hasRole('ROLE_ADMIN')")
    @PostMapping(value = "/items/add")
    public ResponseEntity<Item> addItem(@RequestBody Item item) throws URISyntaxException {
        log.info("Request to create item: {}", item);

        Item result = itemService.update(item);
        return ResponseEntity.created(new URI("/edit/" + result.getId()))
                .body(result);
    }

    //    @PreAuthorize("#oauth2.hasScope('webclient') and #oauth2.hasScope('write') and hasRole('ROLE_ADMIN')")
    @DeleteMapping("/remove/{id}")
    public ResponseEntity<?> removeItem(@PathVariable Integer id) {
        log.info("Request to delete item: {}", id);

        itemService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    //    @PreAuthorize("#oauth2.hasScope('webclient') and #oauth2.hasScope('write') and hasRole('ROLE_ADMIN')")
    @PutMapping("/edit/{id}")
    public ResponseEntity<Item> updateItem(@RequestBody Item item) {
        log.info("Request to update item: {}", item);

        Item result = itemService.update(item);
        return ResponseEntity.ok().body(result);
    }
}
