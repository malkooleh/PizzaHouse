package ua.pizzeria.ws.webservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import ua.pizzeria.services.CategoryService;
import ua.pizzeria.services.ItemService;
import ua.pizzeria.ws.webservices.xml_build.Category;
import ua.pizzeria.ws.webservices.xml_build.GetItemsRequest;
import ua.pizzeria.ws.webservices.xml_build.GetItemsResponse;
import ua.pizzeria.ws.webservices.xml_build.ObjectFactory;
import ua.pizzeria.ws.webservices.xml_build.Item;

import java.util.ArrayList;
import java.util.List;

@Endpoint
public class PizzaHouseServiceImpl {

    private static final String NAMESPACE_URI = "http://localhost:8080/gs-producing-web-service";

    @Autowired
    ItemService itemService;
    @Autowired
    CategoryService categoryService;
//
//    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getItemsRequest")
//    @ResponsePayload
//    public List<Item> getItems() {
//        return itemService.getAll();
//    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getItemsRequest")
    @ResponsePayload
    public GetItemsResponse getItemByCategoryName(@RequestPayload GetItemsRequest request) {
        GetItemsResponse itemsResponse = new GetItemsResponse();
        String categoryName = request.getName();

        ObjectFactory factory = new ObjectFactory();
        List<Item> itemList = new ArrayList<>();
        List<ua.pizzeria.model.Item> items = itemService.getByCategoryID(categoryService.getCategoryByName(categoryName).getId());
        for (ua.pizzeria.model.Item item : items) {
            Item it = factory.createItem();
            Category c = factory.createCategory();
            c.setId(item.getCategory().getId());
            c.setName(item.getCategory().getName());
            it.setCategory(c);
            it.setId(item.getId());
            it.setName(item.getName());
            it.setUnitPrice(item.getUnitPrice());
            itemList.add(it);
        }
        itemsResponse.setItems(itemList);
        return itemsResponse;
    }
}
