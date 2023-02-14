import {Component, OnInit} from '@angular/core';
import {BookService} from "../book-service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-book-info',
  templateUrl: './book-info.component.html',
  styleUrls: ['./book-info.component.css']
})
export class BookInfoComponent implements OnInit{
  // ALARM ATTENTION FIX IT ATTENTION ALARM
  book: any = {}; // NOT ANY
  // ALARM ATTENTION FIX IT ATTENTION ALARM


  constructor(private bookService: BookService,
              private route: ActivatedRoute) {}

  ngOnInit(): void {
    const id = this.route.snapshot.params['id'];
    this.bookService.getBooksById(id)
      .subscribe(
      obj => {
        this.book = obj
      }
    );
  }
}
