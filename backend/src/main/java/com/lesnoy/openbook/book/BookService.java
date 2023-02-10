package com.lesnoy.openbook.book;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    @Transactional
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Transactional
    public Book getById(int id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found with id " + id));
    }

    @Transactional
    public List<Book> getAll() {
        return bookRepository.findAll();
    }
}
