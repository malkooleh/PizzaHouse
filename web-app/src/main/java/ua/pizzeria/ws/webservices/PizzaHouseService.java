package ua.pizzeria.ws.webservices;

import ua.pizzeria.model.Item;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface PizzaHouseService {

    public List<Item> getItems();

    public List<Item> getItemByCategoryName(String name);

}
