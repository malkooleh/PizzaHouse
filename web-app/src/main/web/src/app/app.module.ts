import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {AppComponent} from './app.component';
import {CategoriesComponent} from './views/categories/categories.component';
import { ItemsComponent } from './views/items/items.component';

@NgModule({
  declarations: [
    AppComponent,
    CategoriesComponent,
    ItemsComponent
  ],
  imports: [
    BrowserModule, FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
