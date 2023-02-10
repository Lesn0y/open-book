import {Injectable} from "@angular/core";
import {Observable} from "rxjs";
import {BookCard} from "./book-card";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class BookService {
  private apiUrl = 'http://localhost:8080/api/v1';

  constructor(private http: HttpClient) {}

  public getBooks(): Observable<BookCard[]> {
    return this.http.get<BookCard[]>(`http://localhost:8080/api/v1/book`);
  }
}
