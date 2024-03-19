package org.lesnoy.bookservice.controller;

import lombok.RequiredArgsConstructor;
import org.lesnoy.bookservice.dto.BookRequest;
import org.lesnoy.bookservice.exceptions.BookNotFoundException;
import org.lesnoy.bookservice.model.Book;
import org.lesnoy.bookservice.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/book")
@RequiredArgsConstructor
public class BookController {

    private final BookService service;

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks(@RequestParam(value = "in_stock", required = false) Boolean inStock,
                                                  @RequestParam(value = "item_id", required = false) List<Long> itemsId) {
        if (itemsId != null) {
            return ResponseEntity.ok(service.checkBookInStock(itemsId));
        } else {
            if (inStock != null) {
                return ResponseEntity.ok((service.getAllBooksInStock(inStock)));
            }
            return ResponseEntity.ok(service.getAllBooks());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") Long id) throws BookNotFoundException {
        return ResponseEntity.ok(service.getBookById(id));
    }

    @PostMapping
    public ResponseEntity<Book> saveBook(@RequestBody BookRequest bookDTO) {
        return new ResponseEntity<>(service.saveBook(bookDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBookById(@PathVariable("id") Long id,
                                               @RequestBody(required = false) BookRequest bookDTO) throws BookNotFoundException {
        if (bookDTO == null) {
            return ResponseEntity.ok(service.changeStateInStock(id));
        }
        return ResponseEntity.ok(service.updateBook(id, bookDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBookById(@PathVariable("id") Long id) throws BookNotFoundException {
        service.deleteBookById(id);
        return ResponseEntity.noContent().build();
    }
}
