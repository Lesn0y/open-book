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

    private final BookRepository bookRepository;

    @GetMapping
    public List<Book> getAllBook() {
        return bookRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<?> saveBook(@RequestBody Book book) {
        bookRepository.save(book);
        return new ResponseEntity<>(book,
                HttpStatus.CREATED
        );
    }
}
