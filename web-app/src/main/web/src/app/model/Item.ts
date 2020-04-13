import {Category} from "./Category";

export class Item {

  name: string;
  price: number;
  done: boolean;
  category?: Category;

  constructor(name: string, price: number, category?: Category) {
    this.name = name;
    this.price = price;
    this.done = false;
    this.category = category;
  }
}
