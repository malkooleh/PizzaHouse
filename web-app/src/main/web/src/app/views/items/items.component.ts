import { Component, OnInit } from '@angular/core';
import {Item} from "../../model/Item";
import {DataHandlerService} from "../../services/data-handler.service";
import {Category} from "../../model/Category";

@Component({
  selector: 'app-items',
  templateUrl: './items.component.html',
  styleUrls: ['./items.component.css']
})
export class ItemsComponent implements OnInit {

  items: Item[];

  constructor(private dataHandler: DataHandlerService) { }

  ngOnInit(): void {
    this.items = DataHandlerService.getItems();
  }

  name: string;
  price: number;

  addItem(name: string, price: number, category?: Category): void {

    if (name == null || name.trim() == "" || price == null)
      return;
    this.items.push(new Item(name, price, category));
  }
}
