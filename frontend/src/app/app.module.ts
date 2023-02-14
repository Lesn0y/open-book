import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppComponent} from './app.component';
import {BookCardComponent} from './book-grid/book-card/book-card.component';
import {HttpClientModule} from "@angular/common/http";
import { HeaderComponent } from './header/header.component';
import {RouterModule, Routes} from "@angular/router";
import { BookGridComponent } from './book-grid/book-grid.component';
import { BookInfoComponent } from './book-grid/book-info/book-info.component';
import {FormsModule} from "@angular/forms";

const routeMapper: Routes = [
  {path: '', redirectTo: 'book', pathMatch: 'full'},
  {path: 'book', component: BookGridComponent},
  {path: 'book/:id', component: BookInfoComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    BookCardComponent,
    HeaderComponent,
    BookGridComponent,
    BookInfoComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    RouterModule.forRoot(routeMapper)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
