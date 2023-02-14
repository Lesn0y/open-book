package com.lesnoy.openbook.book;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/api/v1/book")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping
    public ResponseEntity<Page<List<Book>>> getAllBook(
            @RequestParam(value = "genre", required = false) Integer genre,
            @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
            @RequestParam(value = "count", required = false, defaultValue = "12") Integer count) {
        if (genre != null) {
            return ResponseEntity.ok(bookService.getBookByGenre(genre, page, count));
        }
        return ResponseEntity.ok(bookService.getAll(page, count));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") int id) {
        try {
            return ResponseEntity.ok(bookService.getById(id));
        } catch (RuntimeException re) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Book> saveBook(@RequestBody Book book) {
        return new ResponseEntity<>(bookService.save(book), HttpStatus.CREATED);
    }
}
