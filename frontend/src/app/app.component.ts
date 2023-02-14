import {Component, OnInit} from '@angular/core';
import {BookCard} from "./book-grid/book-card/book-card";
import {BookService} from "./book-grid/book-service";
import {HttpErrorResponse} from "@angular/common/http";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{

  constructor(private bookService: BookService) {}

  ngOnInit(): void {

  }
}
