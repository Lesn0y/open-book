import {Injectable} from "@angular/core";
import {Observable} from "rxjs";
import {BookCard} from "./book-card/book-card";
import {HttpClient} from "@angular/common/http";
import {Book} from "./book-info/book";

@Injectable({
  providedIn: 'root'
})
export class BookService {
  private apiUrl = 'http://localhost:8080/api/v1';

  constructor(private http: HttpClient) {}

  public getBooks(): Observable<BookCard[]> {
    return this.http.get<BookCard[]>(`http://localhost:8080/api/v1/book`);
  }

  public getBooksById(id: number) {
    return this.http.get<Book>('http://localhost:8080/api/v1/book/' + id);
  }

  public getBooksByGenre(genreId: number) {
    return this.http.get<Book>('http://localhost:8080/api/v1/book?genre=' + genreId);
  }
}
