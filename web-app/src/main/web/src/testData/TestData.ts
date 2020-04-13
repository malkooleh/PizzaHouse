import {Item} from "../app/model/Item";
import {Category} from "../app/model/Category";

export class TestData {

  static categories: Category[] =
    [
      {id: 1, title: "Pizza"},
      {id: 2, title: "Beer"},
      {id: 3, title: "Salads"}
    ];

  static items: Item[] =
    [
      {name: "Хлеб", done: false, price: 15.9},
      {name: "Масло", done: false, price: 60},
      {name: "Картофель", done: true, price: 22.6},
      {name: "Сыр", done: false, price: 310}
    ];
}
