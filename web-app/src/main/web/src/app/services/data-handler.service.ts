import { Injectable } from '@angular/core';
import {TestData} from "../../testData/TestData";

@Injectable({
  providedIn: 'root'
})
export class DataHandlerService {

  constructor() { }

  static getCategories() {
    return TestData.categories;
  }

  static getItems() {
    return TestData.items;
  }
}
