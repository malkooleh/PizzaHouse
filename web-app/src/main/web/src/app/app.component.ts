import {Component} from '@angular/core';
import {Item} from "./model/Item";
import {Category} from "./model/Category";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {
  title = 'Pizzeria';

  name: string;
  price: number = 0;

  items: Item[] =
    [
      {name: "Хлеб", done: false, price: 15.9},
      {name: "Масло", done: false, price: 60},
      {name: "Картофель", done: true, price: 22.6},
      {name: "Сыр", done: false, price: 310}
    ];

  addItem(name: string, price: number, category?: Category): void {

    if (name == null || name.trim() == "" || price == null)
      return;
    this.items.push(new Item(name, price, category));
  }
}
