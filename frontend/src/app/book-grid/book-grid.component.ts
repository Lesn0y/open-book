import {Component, OnInit} from '@angular/core';
import {HttpErrorResponse} from "@angular/common/http";
import {BookCard} from "./book-card/book-card";
import {BookService} from "./book-service";

@Component({
  selector: 'app-book-grid',
  templateUrl: './book-grid.component.html',
  styleUrls: ['./book-grid.component.css']
})
export class BookGridComponent implements OnInit{
  public books: BookCard[];

  constructor(private bookService: BookService) {}

  ngOnInit(): void {
    this.getBooks();
  }

  public getBooks(): void {
    this.bookService.getBooks().subscribe(
      (response: any) => {
        this.books = response.content;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    )
  }
}
