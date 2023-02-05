package com.lesnoy.openbook.book;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://127.0.0.1:4000")
@RestController
@RequestMapping("/api/v1/book")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping
    public ResponseEntity<List<Book>> getAllBook() {
        return ResponseEntity.ok(bookService.getAll());
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
