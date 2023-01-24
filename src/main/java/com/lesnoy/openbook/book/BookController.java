package com.lesnoy.openbook.book;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/book")
public class BookController {

    private final BookApiService bookApi;

    public BookController(BookApiService bookApi) {
        this.bookApi = bookApi;
    }

//  Возвращает список книг в которых содержится переданная строка
    @GetMapping("/{text}")
    public ResponseEntity<?> getBooksByText(@PathVariable("text") String text) {
        List<Book> books = bookApi.findBookByText(text);
        if (!books.isEmpty()) {
            return new ResponseEntity<>(books,
                                        HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Text - " + text + " not found",
                                        HttpStatus.NOT_FOUND);
        }
    }

//  Возвращает список книг в которых содержится переданный заголовок
    @GetMapping("/title/{title}")
    public ResponseEntity<?> getBooksByTitle(@PathVariable("title") String title) {
        List<Book> books = bookApi.findBooksByTitle(title);
        if (!books.isEmpty()) {
            return new ResponseEntity<>(books,
                                        HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Title - " + title + " not found",
                                        HttpStatus.NOT_FOUND);
        }
    }

//  Возвращает список книг в которых содержится переданный автор
    @GetMapping("/author/{author}")
    public ResponseEntity<?> getBooksByAuthor(@PathVariable("author") String author) {
        List<Book> books = bookApi.findBookByAuthor(author);
        if (!books.isEmpty()) {
            return new ResponseEntity<>(books,
                                        HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Author - " + author + " not found",
                                        HttpStatus.NOT_FOUND);
        }
    }

}
